package com.mrliuli.cloud.controller;

import com.mrliuli.cloud.service.ICallServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by liuli on 2019/12/11.
 */
@RestController
public class HelloController {

    @Autowired
    private ICallServiceA callServiceA;

    @RequestMapping("/call")
    public String hello() {

        // 通过 feign 客户端来消费服务
        // 当 service-a 启动两个实例时，会交替调用两个实例，说明feign集成了ribbon，实现了负载均衡。
        return callServiceA.helloApi();

    }

}
