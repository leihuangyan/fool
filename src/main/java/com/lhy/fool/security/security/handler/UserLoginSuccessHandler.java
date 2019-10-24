package com.lhy.fool.security.security.handler;


import com.lhy.fool.security.common.config.JWTConfig;
import com.lhy.fool.security.common.util.JWTTokenUtil;
import com.lhy.fool.security.common.util.ResultUtil;
import com.lhy.fool.security.security.entity.SelfUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 登录成功处理类
 * @Author Sans
 * @CreateTime 2019/10/3 9:13
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * 登录成功返回结果
     * @Author Sans
     * @CreateTime 2019/10/3 9:27
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // 组装JWT
        SelfUserEntity selfUserEntity =  (SelfUserEntity) authentication.getPrincipal();

        log.info("登录用户user:{}",selfUserEntity);

        //生成JWT
        String token = JWTTokenUtil.createAccessToken(selfUserEntity);
        token = JWTConfig.tokenPrefix + token;
        // 封装返回参数
        Map<String,Object> resultData = new HashMap<>();
        resultData.put("code","0");
        resultData.put("msg", "登录成功");
        resultData.put("token",token);

        log.info("登录成功：{}",resultData);

        ResultUtil.responseJson(response,resultData);
    }
}