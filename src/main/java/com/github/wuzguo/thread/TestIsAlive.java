package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestIsAlive {

    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread2 = new MyThread2();
        System.out.println("myThread2, isAlive: " + myThread2.isAlive());
       // myThread2.start();
        // 直接调用run方法，相当于线程没有启动
        // myThread2.run();

        // 让主线程睡眠 1S
        // Thread.sleep(1000);
        System.out.println("myThread2, isAlive: " + myThread2.isAlive());
        System.out.println("-------------------------------------------------");


        // Thread.currentThread()和this的差异
        MyThread3 myThread3 = new MyThread3();
       // myThread3.start();
        Thread t1 = new Thread(myThread3);
        System.out.println("main begin t1 isAlive: " +t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive: " +t1.isAlive());
    }
}


class MyThread2 extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println(this.getName() + " Run方法： " + this.isAlive());
    }
}

class MyThread3 extends Thread {
    public MyThread3() {
        System.out.println("mythread3 begin ... ");
        System.out.println("thread.currentThread.getName: " + Thread.currentThread().getName());
        System.out.println("thread.currentThread.isAlive: " + Thread.currentThread().isAlive());

        System.out.println("this.getName: " + this.getName());
        System.out.println("this.isAlive: " + this.isAlive());
        System.out.println("mythread3 end ... ");
    }


    @Override
    public void run() {
        super.run();

        System.out.println("run begin ... ");
        System.out.println("thread.currentThread.getName: " + Thread.currentThread().getName());
        System.out.println("thread.currentThread.isAlive: " + Thread.currentThread().isAlive());

        System.out.println("this.getName: " + this.getName());
        System.out.println("this.isAlive: " + this.isAlive());
        System.out.println("run end ... ");
    }
}
