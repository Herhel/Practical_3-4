package com.alfa.work1;

public class MyTimeBomb_1 extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0 ; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exp) { }
        }
        System.out.println("Boom!!!");
    }
}