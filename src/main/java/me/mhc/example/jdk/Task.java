package me.mhc.example.jdk;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello,world";
    }
}
