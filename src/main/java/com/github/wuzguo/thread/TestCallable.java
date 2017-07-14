package com.github.wuzguo.thread;

import com.github.wuzguo.model.Result;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * IntelliJ IDEA 2016.3
 *
 * @author： admin
 * @date： 七月 08, 2017
 * @version: 1.0.0
 * @desc: thread-examples / com.github.wuzguo.thread
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            FutureTask<Result> task = new FutureTask<Result>(new Call());
            new Thread(task).start();
            // 获取运行结果
            Result result = task.get();
            System.out.println("result: " + result);
        }
    }
}

class Call implements Callable<Result> {
    public Result call() throws Exception {
        System.out.println("hello world...");
        return new Result(new Random(10).nextInt(10), true, "hello world");
    }
}

class Run implements Runnable {

    public void run() {
        System.out.println("hello world, i'm runable.");
    }
}