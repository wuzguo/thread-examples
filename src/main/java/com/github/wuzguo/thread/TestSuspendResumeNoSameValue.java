package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestSuspendResumeNoSameValue {
    public static void main(String[] args) throws InterruptedException {
        final MyObject object = new MyObject();
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                object.setValue("AAAA", "aaaa");
            }
        };
        thread.setName("a");
        thread.start();
        Thread.sleep(1000);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println(object.toString());
            }
        };
        thread1.setName("b");
        thread1.start();
    }
}

class MyObject {
    private String name = "Tom";
    private String nick = "Nick";

    public void setValue(String name, String nick) {
        this.name = name;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("暂停线程 a");
            Thread.currentThread().suspend();
        }
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}
