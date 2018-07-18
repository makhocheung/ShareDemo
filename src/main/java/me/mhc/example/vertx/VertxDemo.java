package me.mhc.example.vertx;

import io.vertx.core.Vertx;

public class VertxDemo {
    public static void go() {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyVerticle());
    }
}
