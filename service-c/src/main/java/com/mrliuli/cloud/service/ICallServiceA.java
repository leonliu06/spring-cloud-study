package com.mrliuli.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liuli on 2020/06/23.
 *
 * 定义一个 feign 接口，通过 @FeignClient(value = "服务名") 来指定调用哪个服务。
 *
 * Feign 是一个声明式的伪 http 客户端，它使得写 http 客户端变得更简单（不用使用 RestTemplate 来调用 rest 接口）。
 * 使用 Feign，只需要创建一个接口并注解。
 * Feign 默认集成了 Ribbon，默认实现了负载均衡。
 *
 * 简而言之：
 * Feign 采用的是基于接口的注解
 * Feign 整合了 ribbon，具有负载均衡能力
 * 整合了 Hystrix，具有熔断能力
 *
 */
@FeignClient(value = "service-a")
public interface ICallServiceA {

    /**
     * 调用服务 service-a 的 /hello 接口
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String helloApi();

}
