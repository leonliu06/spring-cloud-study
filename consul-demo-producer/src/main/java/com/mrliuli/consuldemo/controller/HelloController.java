package com.mrliuli.consuldemo.controller;

import com.mrliuli.starterstudy.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * Created by liuli on 2019/12/11.
 */
@RestController
public class HelloController {

    @Autowired
    private MyService myService;

    @RequestMapping("/hello")
    public String hello() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)(RequestContextHolder.getRequestAttributes());
        String[] config = myService.split(",");
        // TODO: 2020/06/16 测试响应超时时，网关服务的响应及如何配置超时时间
        //Thread.sleep(2000L);
        return "hello consul from " + servletRequestAttributes.getRequest().getRequestURL();
    }

}
