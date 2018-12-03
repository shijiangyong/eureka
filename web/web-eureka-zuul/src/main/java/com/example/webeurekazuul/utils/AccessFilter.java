package com.example.webeurekazuul.utils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * 服务请求过滤器
 * @author shijy
 * @Date 2018/12/3 10 : 39
 * @Descriprion
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，true,永远过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info("{]>>>>>{}",request.getMethod(),request.getRequestURI().toString());

        String access_token = request.getParameter("access_token");
        if(StringUtils.isBlank(access_token) || !"test".equals(access_token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("access_token is invalid!");
            logger.info("the request {} is fail, the token is invalid",request.getRequestURI().toString());
        }else{
            logger.info("the request {} is ok", request.getRequestURI().toString());
        }
        return null;
    }
}
