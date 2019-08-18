package com.lhy.fool.task.constant;

import java.io.Serializable;

/**
 * @name: WorkQueueConstant
 * @author： LHY
 * @classPath: com.lhy.fool.task.constant.WorkQueueConstant
 * @date: 2019-08-18 22:17
 * @Version: 1.0
 * @description: WorkQueue 常量
 */
public class WorkQueueConstant  implements Serializable {

    private static final long serialVersionUID = -1542554002462697397L;

    /**
     * 基于数组的先进先出队列，此队列创建时必须指定大小；
     */
    public final  static String ARRAY_BLOCKING_QUEUE ="ARRAY_BLOCKING_QUEUE";

    public final  static String PRIORITY_BLOCKING_QUEUE ="PRIORITY_BLOCKING_QUEUE";


    /**
     * 基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；
     */
    public final  static String LINKED_BLOCKING_QUEUE ="LINKED_BLOCKING_QUEUE";

    /**
     * 这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。
     */
    public final  static String SYNCHRONOUS_QUEUE ="SYNCHRONOUS_QUEUE";

}
