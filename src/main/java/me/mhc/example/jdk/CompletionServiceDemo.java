package me.mhc.example.jdk;

import java.util.concurrent.*;

public class CompletionServiceDemo {
    public static void go()  throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        for (int i = 0; i < 10; i++) {
            completionService.submit(new Task());
        }
        for (int j = 0; j < 10; j++) {
            Future future = completionService.take();
            System.out.println(future.get());
        }
    }
}
