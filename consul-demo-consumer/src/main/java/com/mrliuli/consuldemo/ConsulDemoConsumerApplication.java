package com.mrliuli.consuldemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
public class ConsulDemoConsumerApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ConsulDemoConsumerApplication.class, args);
        System.out.println(applicationContext.getEnvironment().getProperty("secretKey"));
    }

    @Value("${foo}")
    private String foo;

    @RequestMapping("hi")
    public String hi() {
        return foo;
    }

}
