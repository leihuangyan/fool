package com.lhy.fool.util.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *@author 98403
 * @Date: 2019-03-27 15:27
 * @Description: 一个简单的Interceptor拦截器类  urlPattern针对的MVC中的Controller控制器处理的请求
 */
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //只有返回true才会继续向下执行，返回false取消当前请求
        log.debug("=======【拦截器】【MyInterceptor】Controller 执行前 ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.debug("=======【拦截器】【MyInterceptor】Controller 执行完毕");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.debug("=======【拦截器】【MyInterceptor】Controller 渲染前");
    }
}

