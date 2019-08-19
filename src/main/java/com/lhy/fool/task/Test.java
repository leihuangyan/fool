package com.lhy.fool.task;

import com.lhy.fool.task.config.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

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


        final long start = System.currentTimeMillis();

        int threadTotal = 10;
        int count = 50;

        //Set<Callable<String>> cables = new HashSet<>();
        //
        //
        //ExecutorService pool = ThreadPoolExecutorUtil.newFixedThreadPool(new ThreadPoolConfig());
        //for (int n = 1; n <=threadTotal; n++) {
        //
        //    cables.add((Callable) () -> {
        //        for (int i = 0; i < count; i++) {
        //            try {
        //                //模拟耗时操作
        //                Thread.sleep(100);
        //                log.info("ID：{},==当前线程:{},当前进度：{}",
        //                        Thread.currentThread().getId(),
        //                        Thread.currentThread().getName(),
        //                        i);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //        }
        //        return  String.format("开始线程:%s",Thread.currentThread().getName());
        //    });
        //}
        //
        //log.info("=================【线程即将开始执行】==================={}",pool.isTerminated());
        //List<Future<String>> futures = pool.invokeAll(cables);
        //for (Future<String> future : futures) {
        //    log.debug(future.get());
        //}

        //log.info("=================【线程结束】==================={}");
        //
        //pool.shutdown();
        //final long end = System.currentTimeMillis();

        for (int n = 1; n <=threadTotal; n++) {
            for (int i = 0; i < count; i++) {
                try {
                    //模拟耗时操作
                    Thread.sleep(100);
                    log.info("ID：{},==当前线程:{},当前进度：{}",
                            Thread.currentThread().getId(),
                            Thread.currentThread().getName(),
                            i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        final long end = System.currentTimeMillis();

        //log.info("=================【线程状态】{}",pool.isTerminated());
        log.info("=================【耗时】{}",end-start);
        //5092

    }


    public static void main2(String[] args) {


        int threadTotal = 10;
        int count = 50;

        ExecutorService pool = ThreadPoolExecutorUtil.newCachedThreadPool(new ThreadPoolConfig());
        for (int n = 1; n <=threadTotal; n++) {
            log.info("开始第：{}个线程",n);
            pool.execute(() -> {
                for (int i = 0; i < count; i++) {
                    try {

                        //模拟耗时操作
                        Thread.sleep(100);

                        log.info("ID：{},==当前线程:{},当前进度：{}",
                                Thread.currentThread().getId(),
                                Thread.currentThread().getName(),
                                i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        log.info("=================【线程创建结束】==================={}",pool.isTerminated());

        pool.shutdown();
    }

}
