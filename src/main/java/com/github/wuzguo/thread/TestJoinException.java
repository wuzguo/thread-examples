package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 09, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestJoinException {
    public static void main(String[] args) throws InterruptedException {
        MyThread14 myThread14 = new MyThread14("myThread14");
        myThread14.start();

        Thread.sleep(1000);

        MyThread15 myThread15 = new MyThread15(myThread14);
        myThread15.start();
    }
}

class MyThread13 extends Thread {
    public MyThread13(String name) {
        super(name);
    }

    public MyThread13(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Math.random();
        }
    }
}

class MyThread14 extends Thread {

    public MyThread14(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        MyThread13 myThread13 = new MyThread13("myThread13");
        myThread13.start();
        try {
            myThread13.join();
            System.out.println("线程 " + this.getName() + " 运行顺利结束了");
        } catch (InterruptedException e) {
            System.out.println("线程 " + this.getName() + " 运行出现异常了");
            e.printStackTrace();
        }

    }
}

class MyThread15 extends Thread {

    private MyThread14 myThread14;

    public MyThread15(MyThread14 myThread14) {
        super();
        this.myThread14 = myThread14;
    }

    @Override
    public void run() {
        super.run();
        myThread14.interrupt();
    }
}