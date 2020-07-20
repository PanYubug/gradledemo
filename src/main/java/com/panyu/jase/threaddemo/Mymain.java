package com.panyu.jase.threaddemo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Mymain {
    public static void main(String[] args) {

    }

    @Test
    public void givenStartedThread() throws InterruptedException {
        Thread t2 = new SampleThread(10);
        t2.start();
        System.out.println("Invoking join");
        t2.join(1000);
        System.out.println("Returned from join");
        assertTrue(t2.isAlive());
    }
}
