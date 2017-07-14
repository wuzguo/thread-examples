package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestShareData {
    public static void main(String[] args) {
        // 不共享数据
     //   new MyThread("A").start();
    //    new MyThread("B").start();
     //   new MyThread("C").start();

        // 共享数据
        MyThread myThread = new MyThread();
        new Thread(myThread, "AA").start();
        Thread bb = new Thread(myThread, "BB");
        bb.setPriority(6);
        bb.start();
        new Thread(myThread, "CC").start();
    }
}

class MyThread extends Thread {

    private int count = 5;

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    // synchronized可以在任意对象及方法上加锁，而加锁的这段代码称为“互斥区”或“临界区”
    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println(" 由 " + this.currentThread().getName() + " 计算， count: " + count);
        }
    }
}

