package com.lhy.fool.error;


import com.baomidou.mybatisplus.extension.api.R;
import com.lhy.fool.util.other.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 98403
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     *error.html
     */
    private static final String DEFAULT_ERROR_VIEW = "error-diy";


    /**
     * // 所有的异常都是Exception子类
     * @param request request 请求对象
     * @param response response 请求对象
     * @param e 错误信息
     * @return model
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        Integer errorCode;
        ErrorInfo errorInfo = new ErrorInfo();
        final String servletPath = request.getServletPath();
         String msg = null;
        // 对错误类型进行分类 根根据情况定义
        if (e instanceof NullPointerException) {
            // 空指针异常
            errorCode = Error.ERROR_NULL_POINTER.getCode();
        }else  if(e instanceof DuplicateKeyException){
            errorCode = Error.ERROR_NAME_REPEAT.getCode();
            msg = Error.ERROR_NAME_REPEAT.getValue();
        } else {
            // 其他异常
            errorCode = Error.ERROR_OTHER.getCode();
        }
        //设置错误码
        errorInfo.setCode(errorCode);
        errorInfo.setMsg(e.getMessage());
        if(StringUtils.isNotEmpty(msg)){
            errorInfo.setMsg(msg);
        }
        errorInfo.setUrl(servletPath);
        String reg="^(/app)/\\w*/\\w*";
        if (servletPath.matches(reg)) {
            //错误请求来自APP 返回JSON
            doApp(response,errorInfo);
            return null;
        } else {
            //错误请求来自web 返回错误页
            return doWeb(request,errorInfo);
        }
    }


    /**
     * 对web 端
     * @param request request
     * @return ModelAndView
     */
    private ModelAndView doWeb(HttpServletRequest request, ErrorInfo errorInfo){
        ModelAndView mv = new ModelAndView(DEFAULT_ERROR_VIEW);
        // 将异常对象传递过去
        errorInfo.setUrl(request.getRequestURL().toString());
        // 获得请求的路径
        mv.addObject("errorInfo", errorInfo);
        mv.setViewName("error/"+DEFAULT_ERROR_VIEW);
        return mv;
    }

    /**
     * 对APP 端
     * @param response response
     */
    private void  doApp(HttpServletResponse response, ErrorInfo errorInfo){
        R r = new R();
        r.setMsg(errorInfo.msg);
        r.setCode(errorInfo.code);
        JsonUtil.convertJSONObject(r,response);
    }

}
