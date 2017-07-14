package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestInterrupt {

    public static void main(String[] args) throws InterruptedException {
        MyThread9 myThread9 = new MyThread9();
        myThread9.start();
        // Thread.sleep(2000);
        // myThread9.interrupt();
    }
}


class MyThread9 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println(" i = " + (i + 1));

            if (i >= 400000) {
                this.interrupt();
                Thread.currentThread().interrupt();
            }
        }
    }
}