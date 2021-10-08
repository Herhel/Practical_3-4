package com.alfa.work1;

public class Runner {
    public void run() {
        new Thread( () -> {
            for (int i = 10; i > 0 ; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            }
            System.out.println("BoomBoom!");
        }).start();
    }
}
