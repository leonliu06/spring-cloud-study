package com.mrliuli.cloud.service.impl;

import com.mrliuli.cloud.service.ICallServiceA;
import org.springframework.stereotype.Component;

/**
 * Created by liuli on 2020/06/25.
 *
 * 作为 FeignClient 接口的 fallback 类，实现断路器功能，要作为 bean 注入到 IOC 中。
 *
 */
@Component
public class ICallServiceAFallback implements ICallServiceA {

    /**
     * 当 调用 service-a 不可用时，执行断路器方法，快速返回，避免“雪崩”效应。
     * @return
     */
    @Override
    public String helloApi() {
        return "error";
    }

}
