package com.mrliuli.cloud.service.impl;

import com.mrliuli.cloud.service.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liuli on 2020/06/23.
 */
@Service
public class HelloServiceImpl implements IHelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    private static final String SERVICE_A = "service-a";

    @Autowired
    private RestTemplate restTemplate;

    // 通过 restTemplate 来消费 service-a 的 /hello 接口，这里直接用服务名替代了具体的 url 地址，
    // 在 ribbon 中，它会根据服务名来选择具体的服务实体，根据服务实例在请求的时候会用具体的url替换掉服务名

    @Override
    public String callOtherService() {

        // 这里调用服务 service-a，当 service-a 开启两个实例，端口分别为 9101 和 9102 时，
        // 返回结果交替为 hello from http://192.168.30.48:9101/hello 和 hello from http://192.168.30.48:9102/hello
        // 说明实现了负载均衡，访问了不同的服务实例。
        String result = restTemplate.getForObject("http://" + SERVICE_A + "/hello", String.class);

        logger.info(result);

        return result;

    }
}
