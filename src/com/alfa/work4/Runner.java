package com.alfa.work4;

public class Runner {
    public void run() {
        DiningHall d = new DiningHall();
        for (int i = 0; i < 10; i++)
            d.makePizza();

        for (int i = 1; i <= 20; i++)
            new Thread(() -> {
                synchronized (d) {
                    d.servePizza();
                }
            }).start();
    }
}
