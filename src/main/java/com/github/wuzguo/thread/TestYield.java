package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestYield {

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        MyThread6 myThread6 = new MyThread6();
        myThread6.start();
        //  myThread6.run();
        long endTime = System.currentTimeMillis();
        System.out.println("mian 方法耗时: " + (endTime - beginTime) + " 毫秒");
    }
}

class MyThread6 extends Thread {
    @Override
    public void run() {
        super.run();
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 10000000; i++) {
            Thread.yield();
            count = count + (i + 1);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("thread run 方法耗时： " + (endTime - beginTime) + " 毫秒");
    }
}