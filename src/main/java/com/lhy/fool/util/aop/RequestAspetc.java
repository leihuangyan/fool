package com.lhy.fool.util.aop;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 98403
 * @Date: 2019-03-27 15:32
 * @Description: AOP 对指定的controller 进行处理
 */
@Aspect
@Component
@Slf4j
public class RequestAspetc {


    /**
     * 是否关闭日志打印
     */
    private static boolean IS_CLOSED = true;
    /**
     * 是否打印参数
     */
    private static boolean IS_PARAM_PRINT = true;
    /**
     * 是否打印返回值
     */
    private static boolean IS_RETURN_PRINT = true;


    @Pointcut("execution(* *..*Controller.*(..))")
    public void init(){

    }


    @Around("init()")
    public Object around(ProceedingJoinPoint joinPoint) throws  Throwable{
        if (IS_CLOSED) {
            return joinPoint.proceed();
        } else {
            return invoke(joinPoint);
        }
    }

    private Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        //获取类路径
        String clazzName = clazz.getName();
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //参数
        Object[] args = joinPoint.getArgs();
        //得到 HttpServletRequest
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();


        String path = "【Controller："+clazzName + "." + methodName + "】";
        if (IS_PARAM_PRINT) {
            //获取参数名称和值
            Map<String, Object> nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName, args);
            if (0 == nameAndArgs.size()) {
                log.debug(path);
                log.debug("【开始执行，没有参数】");
            } else {
                log.debug(path);
                log.debug("【开始执行，参数如下:】");
            }
            for (Map.Entry<String, Object> entry : nameAndArgs.entrySet()) {
                log.debug("【参数："+entry.getKey() + "=" + entry.getValue()+"】");
            }
        }
        Object returnValue = joinPoint.proceed(args);
        if(IS_RETURN_PRINT){
            log.debug(path);
            log.debug("【执行结束，返回值如下:】");
            log.debug("【返回值】:"+ returnValue);
        }
        return returnValue;
    }

    private Map<String, Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws NotFoundException {
        Map<String, Object> map = new HashMap<String, Object>();
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);
        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++) {
            //paramNames即参数名
            map.put(attr.variableName(i + pos), args[i]);
        }
        return map;
    }


    //@Before("init()")
    //public void before(){
    //    log.debug("=======【前置通知】");
    //}
    //
    //
    //@After("init()")
    //public void after(){
    //    log.debug("=======【后置通知】");
    //}
    //
    //@AfterReturning("init()")
    //public void afterReturning(){
    //    log.debug("=======【后置返回】");
    //}
    //
    //
    //@AfterThrowing("init()")
    //public void afterThrowing(){
    //    log.debug("=======【后置异常】");
    //}


}
