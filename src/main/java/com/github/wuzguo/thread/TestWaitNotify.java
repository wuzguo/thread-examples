package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 10, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread20 myThread20 = new MyThread20("AA ", lock);
        myThread20.start();
        Thread.sleep(3000);
        MyThread21 myThread21 = new MyThread21("BB ", lock);
        myThread21.start();
    }
}


class MyThread20 extends Thread {

    private Object lock;

    public MyThread20(Object lock) {
        this.lock = lock;
    }

    public MyThread20(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();

        synchronized (lock) {
            System.out.println(this.getName() + " 开始执行时间： " + System.currentTimeMillis());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " 结束执行时间： " + System.currentTimeMillis());
        }
    }
}

class MyThread21 extends Thread {
    private Object lock;

    public MyThread21(Object lock) {
        this.lock = lock;
    }

    public MyThread21(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock) {
            System.out.println(this.getName() + " 开始执行时间： " + System.currentTimeMillis());
            lock.notify();
            System.out.println(this.getName() + " 结束执行时间： " + System.currentTimeMillis());
        }
    }
}