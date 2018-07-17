package me.mhc.example.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void go()  throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(new Task());
        String str = future.get();
        System.out.print(str);
        executorService.shutdown();
    }
}
