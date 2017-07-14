package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 09, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        MyThread12 myThread12 = new MyThread12();
        myThread12.setName("AA");
        myThread12.start();
       // Thread.sleep(2000);
        myThread12.join();
        System.out.println("我想让myThread12线程执行完成后我再打印");
    }
}


class MyThread12 extends Thread {
    @Override
    public void run() {
        super.run();

        int sec = (int) (Math.random() * 10000);
        System.out.println("sec: " + sec);
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("I'M  " + this.getName() + ", 我要执行完了.");
    }
}