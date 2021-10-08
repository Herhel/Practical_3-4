package com.alfa.work5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
    public void run() throws InterruptedException {
        Map<Integer, String> map1 = new ConcurrentHashMap<>();
        Runnable run1 = () -> {
            Random random = new Random();
            for (int i = 1; i <= 5; i++) {
                String str = "Num_" + random.nextInt(100);
                map1.put(i, str);
                System.out.println(Thread.currentThread().getName() + " -> Write " + i + "-" + str);
            }
        };

        Runnable run2 = () -> {
            for (int i = 1; i <= 5; i++) {
                String value = map1.get(i);
                System.out.println(Thread.currentThread().getName() + " -> Read " + i + "-" + map1.get(i));
            }
        };

        Thread[] arr = new Thread[100];
        for (int i = 0; i < arr.length; i += 2) {
            arr[i] = new Thread(run1);
            arr[i + 1] = new Thread(run2);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
        long timeStart = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            arr[i].join();
        }
        long timeEnd = System.nanoTime();
        System.out.println("\nTime = " + (timeEnd - timeStart) / 1_000_000.0);

        System.out.println("-----------------------------");
        Map<Integer, String> map2 = new HashMap<>();
        Runnable run11 = () -> {
            Random random = new Random();
            for (int i = 1; i <= 5; i++) {
                synchronized (map2) {
                    String str = "Num_" + random.nextInt(100);
                    map2.put(i, str);
                    System.out.println(Thread.currentThread().getName() + " -> Write " + i + "-" + str);
                }
            }
        };

        Runnable run22 = () -> {
            for (int i = 1; i <= 5; i++) {
                synchronized (map2) {
                    String value = map2.get(i);
                    System.out.println(Thread.currentThread().getName() + " -> Read " + i + "-" + map1.get(i));
                }
            }
        };

        Thread[] arr22 = new Thread[100];
        for (int i = 0; i < arr22.length; i += 2) {
            arr22[i] = new Thread(run11);
            arr22[i + 1] = new Thread(run22);
        }

        for (int i = 0; i < arr22.length; i++) {
            arr22[i].start();
        }
        long timeStart1 = System.nanoTime();
        for (int i = 0; i < arr22.length; i++) {
            arr22[i].join();
        }
        long timeEnd1 = System.nanoTime();
        System.out.println("\nTime = " + (timeEnd1 - timeStart1) / 1_000_000.0);
    }
}
