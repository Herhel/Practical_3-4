package com.alfa.work6;

import java.util.concurrent.RecursiveTask;

public class RecSum extends RecursiveTask<Integer> {
    private Integer[] array;
    private int startIndex;
    private int endIndex;

    public RecSum(Integer[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected Integer compute() {
        if ((endIndex - startIndex) <= 20) {
            Integer sum = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                sum += array[i];
            }
            return sum;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        RecSum first = new RecSum(array, startIndex, middle);
        first.fork();
        RecSum two = new RecSum(array, middle+1, endIndex);
        Integer result = two.compute();
        return first.join() + result;
    }
}
