package me.mhc.example.vertx;

import io.vertx.core.AbstractVerticle;

public class MyVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();
        vertx.createHttpServer().requestHandler(req->{
            req.response().putHeader("content-type","text/plain").end("Hello,world");
        }).listen(8888,"localhost");
    }
}
