package me.mhc.example.jdk;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureDemo {
    public static void go() {
        CompletableFuture.supplyAsync(() -> "hello,world!").thenApply(String::toUpperCase).thenAccept(System.out::println);
        CompletableFuture.supplyAsync(()->{
            //耗时操作
            try {
                URL url = new URL("https://www.baidu.com");
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream in = connection.getInputStream();
                byte[] bytes = new byte[in.available()];
                in.read(bytes);
                return new String(bytes);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }).whenComplete((v,e)->{
            System.out.println(v);
        });
    }
}

