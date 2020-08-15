package com.panyu.jase.threaddemo.java8demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo3 {
    public static Integer cal(Integer para) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return para * para;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> cal(5));
        System.out.println(future.get());

        main2();
        main3();
        main4();
    }

    private static void main2() throws InterruptedException, ExecutionException {
        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> cal(50))
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        //目的是等待cal函数执行完成
        future.get();

    }

    public static Integer calc(Integer para) {
        return para / 0;
    }

    private static void main3() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calc(50))
                .exceptionally(ex -> {
                    System.out.println(ex.toString());
                    return 0;
                })
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();
    }

    public static Integer calc2(Integer para) {
        return para / 2;
    }


    public static void main4() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calc2(50))
                .thenCompose((i) -> CompletableFuture.supplyAsync(() -> calc2(i)))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();
    }

    public static void main5() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(() -> calc2(50));
        CompletableFuture<Integer> intFuture2 = CompletableFuture.supplyAsync(() -> calc2(25));
        CompletableFuture<Void> fu = intFuture.thenCombine(intFuture2, (i, j) -> (i + j))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();
    }
}
