package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 10, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestNotifyHoldLock {
    public static void main(String[] args) {
        // 表明 执行完notify()方法所在的同步synchronized代码块后才释放锁
        Object lock = new Object();
        MyThread24 myThread24 = new MyThread24(" AA", lock);
        myThread24.start();

        NotifyThread notifyThread = new NotifyThread("notifyThread", lock);
        notifyThread.start();

        SyncNotifyMethodThread syncNotifyMethodThread = new SyncNotifyMethodThread("syncNotifyMethodThread", lock);
        syncNotifyMethodThread.start();
    }
}


class ServiceNotify {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 开始 wait() 方法 ...");
                // 释放锁
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " 结束 wait() 方法 ...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void syncNotifyMethod(Object lock) {
       // try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 开始 wait() 方法, 时间：" + System.currentTimeMillis());
                lock.notify();
               // Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " 结束 wait() 方法, 时间：" + System.currentTimeMillis());
            }
      //  } catch (InterruptedException e) {
      //      e.printStackTrace();
       // }
    }
}

class MyThread24 extends Thread {
    private Object lock;

    public MyThread24(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        ServiceNotify service = new ServiceNotify();
        service.testMethod(lock);
    }
}


class NotifyThread extends Thread {
    private Object lock;

    public NotifyThread(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        ServiceNotify serviceNotify = new ServiceNotify();
        serviceNotify.syncNotifyMethod(lock);
    }
}

class SyncNotifyMethodThread extends Thread {
    private Object lock;

    public SyncNotifyMethodThread(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        ServiceNotify serviceNotify = new ServiceNotify();
        serviceNotify.syncNotifyMethod(lock);
    }
}
