package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 09, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestJoinSleep {

    public static void main(String[] args) throws InterruptedException {
        MyThread17 myThread17 = new MyThread17(" myThread17");
        MyThread18 myThread18 = new MyThread18(myThread17);
        myThread18.start();
        Thread.sleep(1000);
        MyThread19 myThread19 = new MyThread19(myThread17);
        myThread19.start();
    }
}


class MyThread17 extends Thread {
    public MyThread17(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println(this.getName() + " 开始运行的时间：" + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " 结束运行的时间：" + System.currentTimeMillis());
    }

    public synchronized void syncPrint() {
        System.out.println("执行syncPrint方法的时间：" + System.currentTimeMillis());
    }
}

class MyThread18 extends Thread {
    private MyThread17 myThread17;

    public MyThread18(MyThread17 myThread17) {
        this.myThread17 = myThread17;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (myThread17) {
                myThread17.start();
                // 验证sleep不释放锁
                Thread.sleep(6000); // 不释放锁

                // 验证join方法释放锁
//                myThread17.join(); // 释放锁
//                for (int i = 0; i < Integer.MAX_VALUE; i++) {
//                    Math.random();
//                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyThread19 extends Thread {
    private MyThread17 myThread17;

    public MyThread19(MyThread17 myThread17) {
        this.myThread17 = myThread17;
    }

    @Override
    public void run() {
        super.run();
        myThread17.syncPrint();
    }
}