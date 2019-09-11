package com.lhy.fool.task.config;


import com.lhy.fool.task.config.constant.ThreadPoolConstant;
import com.lhy.fool.task.enums.RejectedExecutionHandlerEnum;
import com.lhy.fool.task.thread.ThreadFactoryBuilder;
import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @name: ThreadPoolConfig
 * @author： LHY
 * @classPath: com.lhy.fool.task.config.ThreadPoolConfig
 * @date: 2019-08-18 21:36
 * @Version: 1.0
 * @description:  线程池配置文件
 */

@Data
public class ThreadPoolConfig implements Serializable {

    private static final long serialVersionUID = -4207636104047713017L;


    /**
     * 核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列
     */
    private volatile int corePoolSize;

    /**
     * 线程池最大能容忍的线程数
     */
    private volatile int maximumPoolSize;

    /**
     * 线程存货时间
     */
    private volatile long keepAliveTime;

    /**
     * 参数keepAliveTime的时间单位
     */
    private TimeUnit timeUnit ;


    /**
     * 线程池中当前的线程数
     */
    private volatile int poolSize;


    /**
     * 是否允许为核心线程设置存活时间
     */
    private volatile boolean allowCoreThreadTimeOut;

    /**
     * 线程工厂，用来创建线程
     */
    private volatile ThreadFactory threadFactory;

    /**
     * 任务缓存队列，用来存放等待执行的任务
     */
    private volatile BlockingQueue<Runnable> workQueue;

    /**
     * 任务拒绝策略
     */
    private volatile RejectedExecutionHandler handler;




    public ThreadPoolConfig(){
        this(ThreadPoolConstant.CORE_POOL_SIZE);
    }

    public ThreadPoolConfig(int corePoolSize){
        this(corePoolSize,ThreadPoolConstant.MAXIMUM_POOL_SIZE);
    }

    public ThreadPoolConfig(int corePoolSize, int maximumPoolSize){
        this(corePoolSize,maximumPoolSize,ThreadPoolConstant.KEEP_ALIVE_TIME);
    }

    public ThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime){
        this(corePoolSize,maximumPoolSize,keepAliveTime,ThreadPoolConstant.TIME_UNIT);
    }

    public ThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit) {
        this(corePoolSize,maximumPoolSize,keepAliveTime,timeUnit,ThreadPoolConstant.POOL_SIZE);
    }

    public ThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit, int poolSize) {

        this(corePoolSize,maximumPoolSize,keepAliveTime,timeUnit,poolSize,new ThreadFactoryBuilder().build());
    }

    public ThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit, int poolSize, ThreadFactory threadFactory) {
        this(corePoolSize,maximumPoolSize,keepAliveTime,timeUnit,poolSize,threadFactory,WorkQueueConfig.build());
    }

    public ThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit, int poolSize, ThreadFactory threadFactory, BlockingQueue<Runnable> workQueue) {
        this(corePoolSize,maximumPoolSize,keepAliveTime,timeUnit,poolSize,threadFactory,workQueue,RejectedExecutionHandlerEnum.ABORT_POLICY.getHandler());
    }

    public ThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit, int poolSize, ThreadFactory threadFactory, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        this(corePoolSize,maximumPoolSize,keepAliveTime,timeUnit,poolSize,threadFactory,workQueue,handler,ThreadPoolConstant.ALLOWCORE_THREAD_TIMEOUT);
    }

    public ThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit, int poolSize, ThreadFactory threadFactory, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler, boolean allowCoreThreadTimeOut) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.poolSize = poolSize;
        this.threadFactory = threadFactory;
        this.workQueue = workQueue;
        this.handler = handler;
        this.allowCoreThreadTimeOut = allowCoreThreadTimeOut;
    }

    public ThreadPoolConfig setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
        return this;
    }
}
