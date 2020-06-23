package com.mrliuli.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * Created by liuli on 2019/12/11.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)(RequestContextHolder.getRequestAttributes());
        return "hello from " + servletRequestAttributes.getRequest().getRequestURL();
    }

}
