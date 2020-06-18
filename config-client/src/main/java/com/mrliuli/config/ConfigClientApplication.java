package com.mrliuli.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 从Spring Cloud Edgware开始，@EnableDiscoveryClient 或 @EnableEurekaClient 可省略。
 * 只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上
 */
//@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
@RestController
public class ConfigClientApplication {

    @Value("${foo}")
    private String foo;

    @RequestMapping("hi")
    public String hi() {
        return foo;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ConfigClientApplication.class, args);
        System.out.println(applicationContext.getEnvironment().getProperty("secretKey"));
    }


}
