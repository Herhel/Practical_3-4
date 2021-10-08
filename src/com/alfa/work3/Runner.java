package com.alfa.work3;

public class Runner {
    public void run() {
        Storage storage = new Storage();

        Thread printer = new Thread(() -> {
            synchronized (storage) {
                while (!Thread.interrupted()) {
                    while (!storage.isFlag()) {
                        try {
                            storage.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    System.out.println(storage.getValue());
                    storage.setFlag(false);
                    storage.notify();
                }
            }
        });

        printer.start();

        new Thread(() -> {
            synchronized (storage) {
                for (int i = 0; i < 20; i++) {
                    while (storage.isFlag()) {
                        try {
                            storage.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    storage.setValue(storage.getValue() + 1);
                    storage.setFlag(true);
                    storage.notify();
                }
                printer.interrupt();
            }
        }).start();
    }
}
