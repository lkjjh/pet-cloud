package com.al.pet.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
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
public class MyGlobalFilter implements Ordered, GlobalFilter {
    //    @Autowired
//    private TokenService tokenService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        log.info("请求路径:{}", path);
        ServerHttpResponse response = exchange.getResponse();
        // 设置编码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//        if (!tokenService.checkPath(path)) {
//            log.info("不需要验证，放行");
//            return chain.filter(exchange);
//        }
//        String token = request.getHeaders().getFirst("token");
//        if (!tokenService.checkToken(token)) {
//            log.debug("token验证失败");
//            CommonResult<Object> code = CommonResult.code(Code.TOKEN_OUT);
//            byte[] bytes = new byte[0];
//            try {
//                bytes = objectMapper.writeValueAsBytes(code);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            DataBuffer buffer = response.bufferFactory().wrap(bytes);
//            response.writeWith(Mono.just(buffer));
//        }
        log.info("验证成功");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
