package com.lhy.fool.task;

import com.lhy.fool.task.config.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @name: Test
 * @author： LHY
 * @classPath: com.lhy.fool.task.Test
 * @date: 2019-08-18 21:46
 * @Version: 1.0
 * @description: TODO
 */
@Slf4j
public class Test {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        long start = System.currentTimeMillis();

        int threadTotal = 10;
        int count = 50;

        Set<Callable<String>> cables = new HashSet<>();


        ExecutorService pool = ThreadPoolExecutorUtil.newFixedThreadPool(new ThreadPoolConfig());
        for (int n = 1; n <=threadTotal; n++) {

            cables.add((Callable<String>) () -> {
                for (int i = 0; i <= count; i++) {
                    try {
                        //模拟耗时操作
                        Thread.sleep(10);
//                        log.info("ID：{},==当前线程:{},当前进度：{}%",
//                                Thread.currentThread().getId(),
//                                Thread.currentThread().getName(),
//                                i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return  String.format("结束线程:%s",Thread.currentThread().getName());
            });
        }

        log.info("=================【多线程1即将开始执行】");
        List<Future<String>> futures = pool.invokeAll(cables);

        for (Future<String> future : futures) {
            log.debug("返回："+future.get());
        }


         long end = System.currentTimeMillis();
        pool.shutdown();
        log.info("=================【多线程1结束】===================耗时:{}",end-start);


        ExecutorService pool2 = ThreadPoolExecutorUtil.newFixedThreadPool(new ThreadPoolConfig());
        log.info("=================【多线程2即将开始执行】");
        start = System.currentTimeMillis();
        for (int n = 1; n <=threadTotal; n++) {
//            log.info("开始第：{}个线程",n);
            pool2.execute(() -> {
                for (int i = 1; i <=count; i++) {
                    try {
                        //模拟耗时操作
                        Thread.sleep(100);
                        log.info("ID：{},==当前线程:{},当前进度：{}",
                                Thread.currentThread().getId(),
                                Thread.currentThread().getName(),
                                i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool2.shutdown();
        end = System.currentTimeMillis();
        log.info("=================【多线程2结束】===================耗时:{}",end-start);

        log.info("=================【程序2即将开始执行】");
        start = System.currentTimeMillis();
        for (int n = 1; n <=threadTotal; n++) {
            for (int i = 0; i < count; i++) {
                try {
                    //模拟耗时操作
                    Thread.sleep(10);
//                    log.info("ID：{},==当前线程:{},当前进度：{}",
//                            Thread.currentThread().getId(),
//                            Thread.currentThread().getName(),
//                            i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
          end = System.currentTimeMillis();

        log.info("=================【程序2结束】=====================耗时:{}",end-start);

    }



}
