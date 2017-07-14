package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestSleep {
    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();
        System.out.println("beign: " + System.currentTimeMillis());
        // 直接调用run方法，表示main线程sleep 2s
        myThread4.run();
        System.out.println("end:   " + System.currentTimeMillis());

//        MyThread5 myThread5 = new MyThread5();
//        System.out.println("beign: " + System.currentTimeMillis());
//        // 直接调用start方法，表示 myThread5线程sleep 2s
//        myThread5.start();
//        System.out.println("end:   " + System.currentTimeMillis());
    }

}

class MyThread4 extends Thread {
    @Override
    public void run() {
        super.run();

        try {
            System.out.println("run thread name: " + this.currentThread().getName() + " begin ");
            Thread.sleep(2000);
            System.out.println("run thread name: " + this.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        super.run();

        try {
            System.out.println("run thread name: " + this.currentThread().getName() + " begin: " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run thread name: " + this.currentThread().getName() + " end: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}