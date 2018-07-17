package me.mhc.example.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void go()  throws Exception{
        FutureTask<String> futureTask = new FutureTask<>(new Task());
        new Thread(futureTask).start();
        String str = futureTask.get();
        System.out.println(str);
    }
}
