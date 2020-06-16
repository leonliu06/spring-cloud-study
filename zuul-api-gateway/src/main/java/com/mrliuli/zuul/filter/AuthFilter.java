package com.mrliuli.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuli on 2020/06/16.
 *
 * zuul 对服务接口的过滤，实现安全验证
 *
 */
@Component
public class AuthFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public String filterType() {
        // 过滤器类型，pre: 路由之前
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤的顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 逻辑判断是否要过滤
        return true;
    }

    // 过滤器的具体逻辑
    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        logger.info("【{}】>>>【{}】", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString());

        Object token = httpServletRequest.getParameter("token");

        if (token == null) {

            logger.warn("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
            }

            return null;
        }

        logger.info("auth filter ok!");

        return null;
    }
}
