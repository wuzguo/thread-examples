package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestSuspendResume {

    public static void main(String[] args) throws InterruptedException {
        MyThread8 myThread8 = new MyThread8();
        myThread8.start();
        Thread.sleep(5000);

        // 暂停
        myThread8.suspend();
        System.out.println(" A： " + System.currentTimeMillis() + " num = " + myThread8.getNum());
        Thread.sleep(5000);
        System.out.println(" A： " + System.currentTimeMillis() + " num = " + myThread8.getNum());

        //启动
        myThread8.resume();
        Thread.sleep(5000);

        // 暂停
        myThread8.suspend();
        System.out.println(" B： " + System.currentTimeMillis() + " num = " + myThread8.getNum());
        Thread.sleep(5000);
        System.out.println(" B： " + System.currentTimeMillis() + " num = " + myThread8.getNum());
    }
}


class MyThread8 extends Thread {
    private long num = 0L;

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            num++;
        }
    }
}
