package com.mrliuli.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 从Spring Cloud Edgware开始，@EnableDiscoveryClient 或 @EnableEurekaClient 可省略。
 * 只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 通过 @Bean 注入 RestTemplate
    // 通过 @LoadBalanced 开启负载均衡功能

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
