package com.solvd.laba.block1.task5_threads;

public class MainTask1 {

    public static void main(String[] args) {

        // 1. Create 2 Threads using Runnable and Thread.
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable, "MyRunnable");
        Thread thread2 = new MyThread("MyThread");

        thread1.start();
        thread2.start();
    }
}
