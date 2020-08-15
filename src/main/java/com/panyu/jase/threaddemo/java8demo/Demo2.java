package com.panyu.jase.threaddemo.java8demo;

import java.util.concurrent.CompletableFuture;

public class Demo2 {
    public static class AskThread implements Runnable {
        CompletableFuture<Integer> re = null;

        public AskThread(CompletableFuture re) {
            this.re = re;
        }

        @Override
        public void run() {

            int myRe = 0;
            try {
                myRe = re.get() * re.get();
            } catch (Exception e) {

            }
            System.out.println(myRe);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        Thread.sleep(1000);
        //告知完成结果
        future.complete(60);
    }
}
