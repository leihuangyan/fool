package com.lhy.fool.task.config;

import com.lhy.fool.task.constant.WorkQueueConstant;
import lombok.Data;

import java.util.Collection;
import java.util.concurrent.*;

/**
 * @name: WorkQueueConfig
 * @author： LHY
 * @classPath: com.lhy.fool.task.config.WorkQueueConfig
 * @date: 2019-08-18 22:37
 * @Version: 1.0
 * @description: TODO
 */
@Data
public class WorkQueueConfig<E> {


    /**
     * 改变状态需要重新设值
     */
    private String constant = WorkQueueConstant.LINKED_BLOCKING_QUEUE;

    private Integer capacity = 10;

    private Boolean fair;

    private Collection<? extends E> coll;


    public  BlockingQueue<E> build(){
        return build(capacity);
    }

    public  BlockingQueue<E> build(Integer capacity){

        if(constant.equals(WorkQueueConstant.ARRAY_BLOCKING_QUEUE)){
            return new ArrayBlockingQueue<>(capacity);

        }else if (constant.equals(WorkQueueConstant.PRIORITY_BLOCKING_QUEUE)){
            return new PriorityBlockingQueue<>();

        }else if (constant.equals(WorkQueueConstant.LINKED_BLOCKING_QUEUE)){
            return new LinkedBlockingQueue<>();

        }else if (constant.equals(WorkQueueConstant.SYNCHRONOUS_QUEUE)){
            return new SynchronousQueue<>();
        }else {
            return new LinkedBlockingQueue<>();
        }
    }


}
