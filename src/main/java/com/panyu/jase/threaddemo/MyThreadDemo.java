package com.panyu.jase.threaddemo;

public class MyThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
          public void run(){
              while (true){
                  if (Thread.currentThread().isInterrupted()){
                      System.out.println("Interrupted!");
                      break;
                  }
                  try {
                      Thread.sleep(2000);
                  }catch (InterruptedException e){
                      System.out.println("Interrupted When Sleep");
                      //设置中断状态
                      Thread.currentThread().interrupt();
                  }
                  Thread.yield();
              }
          }
        };

        t1.start();
        t1.interrupt();
    }
}
