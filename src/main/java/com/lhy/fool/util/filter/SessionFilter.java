package com.lhy.fool.util.filter;

import com.baomidou.mybatisplus.extension.api.R;
import com.lhy.fool.util.redis.RedisDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lhy
 * @Auther: 98403
 * @Date: 2019-03-27 14:27
 * @Description: 过滤器  (Servlet范畴的API)  urlPattern针对的是所有的请求
 * */
@Slf4j
public class SessionFilter implements Filter {

    /**
     * 不需要过滤的list列表
     */
    private static List<Pattern> patterns = new ArrayList();

    private static  R r = new R();

    @Autowired
    private RedisDao redisDao;

    static {
        //发送验证码
        patterns.add(Pattern.compile("^base/sendVCode"));
    }


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(1);
        }
        log.debug("=======【"+url+"】");
        //例子:app/getById
        //是否不需要过滤
        if (isInclude(url)){
            log.debug("=======【不需要过滤】");
            chain.doFilter(httpRequest, httpResponse);
        } else {
            //直接返回
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 是否不需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            //正则匹配
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

}