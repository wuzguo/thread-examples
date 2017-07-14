package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 10, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestWaitReleaseLock {
    public static void main(String[] args) {
        Object lock = new Object();
        MyThread22 myThread22 = new MyThread22("AA", lock);
        myThread22.start();

        MyThread23 myThread23 = new MyThread23("BB", lock);
        myThread23.start();
    }

}


class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 开始 wait() 方法 ...");
                // 释放锁
                lock.wait();
                // 不释放锁，同步效果
                // Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " 结束 wait() 方法 ...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyThread22 extends Thread {
    private Object lock;

    public MyThread22(Object lock) {
        this.lock = lock;
    }

    public MyThread22(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.testMethod(lock);
    }
}

class MyThread23 extends Thread {
    private Object lock;

    public MyThread23(Object lock) {
        this.lock = lock;
    }

    public MyThread23(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.testMethod(lock);
    }
}
