package com.github.wuzguo.thread;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 10, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestWaitNotSync {
    public static void main(String[] args) throws InterruptedException {
        String str = new String();
        // synchronized (str) {
        str.wait();
        //  }
    }
}
