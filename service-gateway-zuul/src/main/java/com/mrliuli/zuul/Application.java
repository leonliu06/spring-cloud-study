package com.mrliuli.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;

/**
 * 从Spring Cloud Edgware开始，@EnableDiscoveryClient 或 @EnableEurekaClient 可省略。
 * 只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上
 */
//@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy    // 使应用开启 zuul 功能
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        System.out.println(applicationContext.getEnvironment().getProperty("secretKey"));
    }

}
