package com.solvd.laba.block1.task5_threads;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) {

        // 1. Create 2 Threads using Runnable and Thread.
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable, "MyRunnable");
        Thread thread2 = new MyThread("MyThread");

        thread1.start();
        thread2.start();
    }

}

class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}