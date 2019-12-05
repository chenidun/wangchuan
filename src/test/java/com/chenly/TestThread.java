package com.chenly;

import com.chenly.model.MyCallable;
import com.chenly.model.MyThread;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wangchuan
 * @date 2019/11/19.
 */
@SpringBootTest
public class TestThread {
    @Test
    public void testThread() {
        MyThread t = new MyThread("冯起红变猪");
        Thread thread = new Thread(t);
        thread.setDaemon(true); // 设置此线程为守护线程
        thread.start();
    }
    @Test
    public void testCallable()  {
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        // 创建多个又返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MyCallable c = new MyCallable(i + "");
            // 执行任务，并获取future对象
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();
        list.forEach(l -> {
            try {
                System.out.println("result:" + l.get().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
//            for (Future f : list) {
//                System.out.println("result:" + f.get().toString());
//            }
    }
}
