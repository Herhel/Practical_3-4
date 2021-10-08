package com.alfa.work2;

public class MySumCount_2 implements Runnable {
    private int startIndex;
    private int stopIndex;
    private Integer[] myArray;
    private long resultSum;

    public MySumCount_2(int startIndex, int stopIndex, Integer[] myArray) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.myArray = myArray;
    }

    public long getResultSum() {
        return resultSum;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= stopIndex; i++) {
            resultSum += myArray[i];
        }
    }
}