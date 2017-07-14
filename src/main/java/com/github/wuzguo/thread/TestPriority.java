package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestPriority {

    public static void main(String[] args) {
        System.out.println(" main thread default priority: " + Thread.currentThread().getPriority());
        // 优先级具有继承性（A线程启动B线程，则B线程的优先级与A的优先级一样）
        Thread.currentThread().setPriority(6);
        System.out.println(" main thread new priority: " + Thread.currentThread().getPriority());
        MyThread7 myThread7 = new MyThread7();
        myThread7.start();
        // 但是这种通过执行 myThread7 中的 runable任务的方式不行
//        Thread thread = new Thread(myThread7);
//        thread.setPriority(8);
//        thread.start();

    }

}

class MyThread7 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("myThread7 run priority: " + this.currentThread().getPriority());
        System.out.println("this run priority: " + this.getPriority());
    }
}
