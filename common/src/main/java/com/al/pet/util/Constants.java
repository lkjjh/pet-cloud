package com.al.pet.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 常量
 *
 * @author al
 * @version 1.0
 */
@Component
public class Constants {

    @Component("gatWay")
    @ConfigurationProperties("gatway.token")
    @Data
    public static class GatWay {
        private List<String> pathList;
    }

    @Component("system")
    @ConfigurationProperties("system")
    @Data
    public static class System {
        private String ums;
        private String oms;
        private String pms;
        private String cart;
    }

    public static class Address {
        public static final String ADDRESS = "https://pet-source-image.oss-cn-shenzhen.aliyuncs.com/";
    }

    /**
     * 订单相关常量
     */
    @Component
    public static class Order {

        /**
         * 个人最大收货地址数量
         */
        public static Integer RECEIVER_ADDRESS_MAX = 20;
        /**
         * 收货人姓名长度限制
         */
        public static Integer USERNAME_LENGTH_MAX = 10;
        /**
         * 收货详细地址长度限制
         */
        public static Integer ADDRESS_LENGTH_MAX = 200;
        /**
         * 过期时间
         */
        public static String EXPIRATION_TIME = String.valueOf(1000 * 60 * 30);

        @Data
        @Component("rabbitMq")
        @ConfigurationProperties("rabbit.order")
        public static class RabbitMq {
            private String exchange;
            private String queue;
            private String routingKey;
            private String dlxExchange;
            private String dlxQueue;
            private String dlxRoutingKey;
        }

        /**
         * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->超时
         */
        public static class Status {
            /**
             * 待付款
             */
            public static Integer OBLIGATION = 0;
            /**
             * 待发货
             */
            public static Integer WAIT_DELIVERY = 1;
            /**
             * 已发货
             */
            public static Integer DELIVERY = 2;
            /**
             * 已完成
             */
            public static Integer FINISH = 3;
            /**
             * 已关闭
             */
            public static Integer CLOSE = 4;
            /**
             * 超时
             */
            public static Integer TIMEOUT = 5;
        }

        /**
         * 支付状态
         */
        public static class PayStatus {
            /**
             * 待支付
             */
            public static Integer WAIT = 0;
            /**
             * 支付成功
             */
            public static Integer SUCCESS = 1;
            /**
             * 支付失败
             */
            public static Integer FAIL = 2;
        }

        /**
         * 支付方式
         */
        public static class PayWay {
            /**
             * 在线支付
             */
            public static Integer ONLINE = 0;
            /**
             * 货到付款
             */
            public static Integer CASH_ON_DELIVERY = 1;
        }


    }

    /**
     * 支付相关常量
     */
    public static class Pay {
        /**
         * 支付订单号追加字符长度
         */
        public static int ORDER_NO_APPEND_SIZE = 6;

        /**
         * 支付方式
         */
        public static class PayWay {
            /**
             * 阿里支付
             */
            public static Integer ALI = 1;
            /**
             * 微信支付
             */
            public static Integer WECHAT = 2;
        }

        /**
         * 支付状态
         */
        public static class PayStatus {
            /**
             * 待支付
             */
            public static Integer WAIT = 0;
            /**
             * 支付成功
             */
            public static Integer SUCCESS = 1;
            /**
             * 支付失败
             */
            public static Integer FAIL = 2;
        }

        /**
         * 支付记录状态
         */
        public static class PayLogStatus {
            /**
             * 成功
             */
            public static Integer SUCCESS = 1;
            /**
             * 失败
             */
            public static Integer FAIL = 2;
        }
    }

}
