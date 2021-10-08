package com.alfa.work2;

public class MySumCount_1 extends Thread {
    private int startIndex;
    private int stopIndex;
    private Integer[] myArray;
    private long resultSum;

    public MySumCount_1(int startIndex, int stopIndex, Integer[] myArray) {
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
