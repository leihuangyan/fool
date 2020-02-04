package com.cz.task.restul.util;


import java.lang.reflect.Field;

/**
 * @name: ReflectUtil
 * @author: LHY
 * @classPath: com.cz.task.restul.util.ReflectUtil
 * @date: 2020/2/4 13:01
 * @Version: 1.0
 * @description: 反射
 */
public class ReflectUtil {


    /**
     *得到属性
     * @param beanClass class
     * @return  Field[]
     * @throws SecurityException
     */
    public static Field[] getFields(Class<?> beanClass) throws SecurityException {
        //得到所有属性
        return beanClass.getDeclaredFields();
    }


    /**
     * 得到属性值
     * @param obj obj
     * @param field field
     * @return object
     */
    public static Object getFieldValue(Object obj, Field field) {
        //判断属性是否为空
        if (null != obj && null != field) {
            //设置权限
            field.setAccessible(true);
            Object result;
            try {
                //得到
                result = field.get(obj);
                return result;
            } catch (IllegalAccessException var4) {
                throw new RuntimeException("反射获取属性值失败:{0}",var4);
            }
        } else {
            return null;
        }
    }
}
