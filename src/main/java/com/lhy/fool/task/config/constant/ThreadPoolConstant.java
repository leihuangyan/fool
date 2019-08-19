package com.lhy.fool.task.config.constant;

import javafx.concurrent.Worker;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @name: ThreadPoolConstant
 * @author： LHY
 * @classPath: com.lhy.fool.task.constant.ThreadPoolConstant
 * @date: 2019-08-19 11:24
 * @Version: 1.0
 * @description: 线程池常量
 */
public class ThreadPoolConstant {

    /**
     * 核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列
     */
    public final static int CORE_POOL_SIZE = 10;

    /**
     * 线程池最大能容忍的线程数
     */
    public final static int MAXIMUM_POOL_SIZE= 15;

    /**
     * 线程池中当前的线程数
     */
    public final static int POOL_SIZE= 0;

    /**
     * 线程存货时间
     */
    public final static long KEEP_ALIVE_TIME= 10;

    /**
     * 参数keepAliveTime的时间单位
     */
    public static TimeUnit TIME_UNIT= TimeUnit.SECONDS;

    /**
     * 是否允许为核心线程设置存活时间
     */
    public final static boolean ALLOWCORE_THREAD_TIMEOUT= false;

    /**
     * 用来记录线程池中曾经出现过的最大线程数
     */
    public int LARGEST_POOL_SIZE= 10;

    /**
     * 用来记录已经执行完毕的任务个数
     */
    public int COMPLETED_TASK_COUNT= 10;


    /**
     * 线程池的主要状态锁，对线程池状态（比如线程池大小
     */
    public final ReentrantLock mainLock = new ReentrantLock();


    /**
     * runState等）的改变都要使用这个锁
     * 用来存放工作集
     */
    public final HashSet<Worker> workers = new HashSet<>();

}
