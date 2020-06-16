package com.mrliuli.consuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 从Spring Cloud Edgware开始，@EnableDiscoveryClient 或 @EnableEurekaClient 可省略。
 * 只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class ConsulDemoProducerApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ConsulDemoProducerApplication.class, args);
        System.out.println(applicationContext.getEnvironment().getProperty("secretKey"));
    }

}
