package com.lhy.fool.task.enums;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @name: RejectedExecutionHandlerEnum
 * @author： LHY
 * @classPath: com.lhy.fool.task.enums.RejectedExecutionHandlerEnum
 * @date: 2019-08-18 22:54
 * @Version: 1.0
 */
public enum RejectedExecutionHandlerEnum {

    /**
     * 丢弃任务并抛出RejectedExecutionException异常
     */
    ABORT_POLICY(new ThreadPoolExecutor.AbortPolicy()),

    /**
     * 也是丢弃任务，但是不抛出异常
     */

    DISCARD_POLICY(new ThreadPoolExecutor.DiscardPolicy()),
    /**
     * 丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     */

    DISCARD_OLDEST_POLICY(new ThreadPoolExecutor.DiscardOldestPolicy()),
    /**
     * 由调用线程处理该任务
     */
    CALLER_RUNS_POLICY(new ThreadPoolExecutor.CallerRunsPolicy());

    public   RejectedExecutionHandler handler;

    RejectedExecutionHandlerEnum(RejectedExecutionHandler handler) {
        this.handler = handler;
    }

    public RejectedExecutionHandler getHandler() {
        return handler;
    }
}
