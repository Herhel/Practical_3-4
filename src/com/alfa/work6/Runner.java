package com.alfa.work6;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Runner {
    public void run() {
        Integer[] arrays = createArrays();
        System.out.println(Arrays.toString(arrays));
        RecursiveTask<Integer> recTask = new RecSum(arrays, 0, arrays.length - 1);
        ForkJoinPool pool = new ForkJoinPool(4);
        Integer result = pool.invoke(recTask);
        System.out.println("Sum = " + result);
    }

    public Integer[] createArrays() {
        Random random = new Random(100);
        Integer[] arrays = new Integer[50];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = random.nextInt(10);
        }
        return arrays;
    }
}
