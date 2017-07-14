package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestInterruptStatus {

    public static void main(String[] args) throws InterruptedException {
        MyThread10 myThread10 = new MyThread10();
        myThread10.start();
        Thread.sleep(1000);
        Thread.currentThread().interrupt();
        myThread10.interrupt();
        // interrupted 具有状态清除功能，第二次调用将返回为false
        System.out.println("是否停止 1： " + myThread10.interrupted());
        System.out.println("是否停止 2： " + myThread10.interrupted());
        // 以下方法有异常
        System.out.println("是否停止 3： " + myThread10.isInterrupted());
        System.out.println("是否停止 4： " + myThread10.isInterrupted());
    }
}


class MyThread10 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            //   System.out.println("i = " + (i + 1));
            // System.out.println("当前线程是否停止： " + this.isInterrupted());
        }
    }
}