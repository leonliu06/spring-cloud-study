package com.mrliuli.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
