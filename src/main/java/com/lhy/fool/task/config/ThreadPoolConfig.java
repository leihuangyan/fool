package com.lhy.fool.task.config;

import javafx.concurrent.Worker;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @name: ThreadPoolConfig
 * @author： LHY
 * @classPath: com.lhy.fool.task.config.ThreadPoolConfig
 * @date: 2019-08-18 21:36
 * @Version: 1.0
 * @description:  TODO 代办将数字添加到yml文件
 */
@Data
public class ThreadPoolConfig implements Serializable {

    protected static final long serialVersionUID = -4207636104047713017L;


    /**
     * 核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列
     */
    private volatile int corePoolSize;

    /**
     * 线程池最大能容忍的线程数
     */
    private volatile int maximumPoolSize;

    /**
     * 线程池中当前的线程数
     */
    private volatile int poolSize;


    /**
     * 线程存货时间
     */
    private volatile long keepAliveTime;

    /**
     * 参数keepAliveTime的时间单位
     */
    private TimeUnit timeUnit;

    /**
     * 线程工厂，用来创建线程
     */
    private volatile ThreadFactory threadFactory;

    /**
     * 任务缓存队列，用来存放等待执行的任务
     */
    private BlockingQueue<Runnable> workQueue;

    /**
     * 任务拒绝策略
     */
    private volatile RejectedExecutionHandler handler;


    /**
     * 线程池的主要状态锁，对线程池状态（比如线程池大小
     */
    private final ReentrantLock mainLock = new ReentrantLock();


    /**
     * runState等）的改变都要使用这个锁
     * 用来存放工作集
     */
    private final HashSet<Worker> workers = new HashSet<>();

    /**
     * 是否允许为核心线程设置存活时间
     */
    private volatile boolean allowCoreThreadTimeOut;

    /**
     * 用来记录线程池中曾经出现过的最大线程数
     */
    private int largestPoolSize;

    /**
     * 用来记录已经执行完毕的任务个数
     */
    private long completedTaskCount;


    public ThreadPoolConfig(BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler, long keepAliveTime, TimeUnit timeUnit, int corePoolSize, int maximumPoolSize, int poolSize) {
        this.workQueue = workQueue;
        this.threadFactory = threadFactory;
        this.handler = handler;
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.poolSize = poolSize;
    }

    public ThreadPoolConfig(WorkQueueConfig workQueueConfig, ThreadFactory threadFactory, RejectedExecutionHandler handler, long keepAliveTime, TimeUnit timeUnit, int corePoolSize, int maximumPoolSize, int poolSize) {
        this(workQueueConfig.build(), threadFactory, handler, keepAliveTime, timeUnit, corePoolSize, maximumPoolSize, poolSize);
    }
}
