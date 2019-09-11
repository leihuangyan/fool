package com.lhy.fool.task;


import com.lhy.fool.task.concurrent.CachedThreadPool;
import com.lhy.fool.task.concurrent.FixedThreadPool;
import com.lhy.fool.task.config.ThreadPoolConfig;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @name: ThreadPoolExecutorUtil
 * @author： LHY
 * @classPath: com.lhy.fool.task.ThreadPoolExecutorUtil
 * @date: 2019-08-18 21:16
 * @Version: 1.0
 * @description: 执行线程池帮助类
 */
public class ThreadPoolExecutorUtil implements Serializable {


    private static final long serialVersionUID = 1671417312214383829L;

    public static ThreadPoolExecutor newFixedThreadPool(ThreadPoolConfig config){
        return FixedThreadPool.build(config);
    }


    public static ExecutorService newCachedThreadPool(ThreadPoolConfig config) {

         ExecutorService executorService = Executors.newCachedThreadPool();
        return  CachedThreadPool.build(config);
    }



}
