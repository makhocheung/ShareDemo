package me.mhc.example;

import io.vertx.core.Vertx;
import me.mhc.example.jdk.CompletableFutureDemo;
import me.mhc.example.jdk.CompletionServiceDemo;
import me.mhc.example.jdk.FutureDemo;
import me.mhc.example.jdk.FutureTaskDemo;
import me.mhc.example.vertx.VertxDemo;

public class Main {
    public static void main(String[] args) throws Exception {
        //FutureDemo.go();
        //FutureTaskDemo.go();
        //CompletionServiceDemo.go();
        //CompletableFutureDemo.go();
        VertxDemo.go();
        Thread.sleep(5000);
    }
}
