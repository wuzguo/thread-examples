package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestSuspendResumeDealLock {
    public static void main(String[] args) throws InterruptedException {
        final SyncObject object = new SyncObject();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                object.printString();
            }
        };

        thread1.setName("a");
        thread1.start();
        Thread.sleep(1000);

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                // thread2 started, 但是进入不了 printString() 方法，因为 printString()被a线程锁定了，并且a线程永远的暂停了。
                object.printString();
            }
        };
        thread2.setName("a");
        thread2.start();
    }
}


class SyncObject {
    public synchronized void printString() {
        System.out.println("begin ...");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a 线程永远的 suspend ..");
            Thread.currentThread().suspend();
        }
        System.out.println("end ...");
    }
}