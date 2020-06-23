package com.mrliuli.cloud.controller;

import com.mrliuli.cloud.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by liuli on 2019/12/11.
 */
@RestController
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping("/call")
    public String hello() {

        return helloService.callOtherService();

    }

}
