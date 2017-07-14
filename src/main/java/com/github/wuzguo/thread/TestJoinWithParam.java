package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 09, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestJoinWithParam {
    public static void main(String[] args) throws InterruptedException {
        MyThread16 myThread16 = new MyThread16();
        myThread16.start();
       // myThread16.join(2000);
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "线程结束时间：" + System.currentTimeMillis());
    }
}


class MyThread16 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("开始睡眠时间：" + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束睡眠时间：" + System.currentTimeMillis());
    }
}