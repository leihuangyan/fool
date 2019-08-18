package com.lhy.fool.task.concurrent;

import com.lhy.fool.task.config.ThreadPoolConfig;

import java.io.Serializable;
import java.util.concurrent.*;

/**
 * @name: CachedThreadPool
 * @author： LHY
 * @classPath: com.lhy.fool.task.concurrent.CachedThreadPool
 * @date: 2019-08-18 21:34
 * @Version: 1.0
 * @description: 可缓存线程池
 */
public class CachedThreadPool extends ThreadPoolExecutor implements Serializable {

    private static final long serialVersionUID = 7099191455814206205L;


    public CachedThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public static CachedThreadPool build(ThreadPoolConfig config) {
        return  new CachedThreadPool(config.getCorePoolSize(),
                config.getMaximumPoolSize(),
                config.getKeepAliveTime(),
                config.getTimeUnit(),
                config.getWorkQueue(),
                config.getThreadFactory(),
                config.getHandler());
    }
}
