package com.lhy.fool.util.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author 98403
 */
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    /**
     *  储存
     * @param key  键
     * @param value 值
      */
    public  void setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        //1分钟过期
        ops.set(key,value,1, TimeUnit.MINUTES);
    }

    /**
     *  储存  day天后过期
     * @param key  键
     * @param value 值
     */
    public  void setKey(String key,String value,long day){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value,day, TimeUnit.DAYS);
    }

    /**
     *  储存永久
     * @param key  键
     * @param value 值
     */
    public  void setKeyForEver(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }

    /**
     *   根据键得到值
     * @param key  键
     * @return  值
     */
    public String getValue(String key){
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }
}

