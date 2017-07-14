package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestCurrentThread {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("AA");
        myThread1.start();
        myThread1.run();

//        System.out.println("----------------------------------");
//
//        MyThread11 myThread11 = new MyThread11();
//        // MyThread11 myThread11 = new MyThread11("myThread11");
//        Thread t1 = new Thread(myThread11);
//        t1.setName("AA");
//        t1.start();

    }
}

class MyThread1 extends Thread {
    public MyThread1() {
        System.out.println("构造方法： " + Thread.currentThread().getName());
    }

    public MyThread1(String name) {
        super(name);
        System.out.println("构造方法： " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Run方法： " + Thread.currentThread().getName());
    }
}


class MyThread11 extends Thread {

    public MyThread11() {
        System.out.println("mythread11 begin ..");
        System.out.println("thread.currentThread.getName： " + Thread.currentThread().getName());
        System.out.println("this.getName： " + this.getName());
        System.out.println("mythread11 end ..");
    }

    public MyThread11(String name) {
        super(name);
        System.out.println("mythread11 name begin ..");
        System.out.println("thread.currentThread.getName： " + Thread.currentThread().getName());
        System.out.println("this.getName： " + this.getName());
        System.out.println("mythread11 name end ..");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run begin ..");
        System.out.println("thread.currentThread.getName： " + Thread.currentThread().getName());
        System.out.println("this.getName： " + this.getName());
        System.out.println("run end ..");
    }
}