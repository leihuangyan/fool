package com.lhy.fool.task.concurrent;

import com.lhy.fool.task.builder.Builder;
import com.lhy.fool.task.config.ThreadPoolConfig;
import com.lhy.fool.task.config.WorkQueueConfig;

import java.io.Serializable;
import java.util.concurrent.*;

/**
 * @name: FixedThreadPool
 * @author： LHY
 * @classPath: com.lhy.fool.task.concurrent.FixedThreadPool
 * @date: 2019-08-19 22:37
 * @Version: 1.0
 * @description: TODO
 */
public class FixedThreadPool extends ThreadPoolExecutor implements Builder,Serializable {

    @Override
    public FixedThreadPool build() {
       return build(new ThreadPoolConfig());
    }

    public static FixedThreadPool build(ThreadPoolConfig config) {
        config.setWorkQueue(WorkQueueConfig.build(WorkQueueConfig.capacity));
        config.setMaximumPoolSize(config.getCorePoolSize());
        config.setKeepAliveTime(0L);
        config.setTimeUnit(TimeUnit.MILLISECONDS);
        return  new FixedThreadPool(config.getCorePoolSize(),
                config.getMaximumPoolSize(),
                config.getKeepAliveTime(),
                config.getTimeUnit(),
                config.getWorkQueue());
    }

    public FixedThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public FixedThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public FixedThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public FixedThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

}
