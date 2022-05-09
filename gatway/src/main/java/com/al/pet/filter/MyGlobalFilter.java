package com.al.pet.filter;

import com.al.pet.enums.Code;
import com.al.pet.util.CommonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器，验证token和统一字符
 *
 * @author al
 * @version 1.0
 */
@Component
@Slf4j
@DependsOn("restTemplate")
public class MyGlobalFilter implements Ordered, GlobalFilter {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service.authentication.name}")
    private String host;

    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        log.info("请求路径:{}", path);
        ServerHttpResponse response = exchange.getResponse();
        // 设置编码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        Boolean checkPath = restTemplate.getForObject("{1}/api/authentication/checkPath/\\/api/ums/sms/sendSms", Boolean.class, host);
        if (!checkPath) {
            log.info("不需要验证，放行");
            return chain.filter(exchange);
        }

        String token = request.getHeaders().getFirst("token");
        Boolean checkToken = restTemplate.getForObject("{1}/api/authentication/checkToken/{2}", Boolean.class, host, token);
        if (!checkToken) {
            log.debug("token验证失败");
            CommonResult<Object> code = CommonResult.code(Code.TOKEN_OUT);
            byte[] bytes = new byte[0];
            try {
                bytes = objectMapper.writeValueAsBytes(code);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            response.writeWith(Mono.just(buffer));
        }
        log.info("验证成功");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
