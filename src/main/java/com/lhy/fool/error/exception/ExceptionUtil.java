package com.lhy.fool.error.exception;

import org.apache.commons.lang3.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;


/**
 * @author 98403
 * @date: 2019-07-19 19:58
 */
public class ExceptionUtil {
    /**
     * 处理excepiton 中的信息，并抛出BusiException
     * @author 376277
     * @date 2017-5-7下午12:51:16
     * @return void
     */
    public static void throwBusiException(Exception e){
        //获取异常消息
        String msg = getExceptionMsg(e);
        throw new RuntimeException(msg);
    }

    /**
     * 处理excepiton 中的信息，并返回BusiException对象
     * @author 376277
     * @date 2017-5-7下午12:51:16
     * @return void
     */
    public static RuntimeException throwBusiException1(Exception e){
        //获取异常消息
        String msg = getExceptionMsg(e);
        return new RuntimeException(msg);
    }

    /**
     * 返回异常信息描述。
     * @author 376277
     * @date 2017-5-7下午12:51:16
     * @return void
     */
    public static String returnExceptionMsg(Exception e){
        //获取异常消息
        String msg = getExceptionMsg(e);
        return msg;
    }

    private static String getExceptionMsg(Exception e) {
        String msg = e.getMessage();
        if (StringUtils.isEmpty(msg)) {
            //如果返回的异常消息为空，则获取异常信息返回。
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            e.printStackTrace(new PrintStream(out));
            msg = out.toString();
            try {
                out.close();
            } catch (IOException e1) {
                throw new RuntimeException("处理异常信息，关闭输出流发生异常：", e1.getCause());
            }
        }
        return msg;
    }
}
