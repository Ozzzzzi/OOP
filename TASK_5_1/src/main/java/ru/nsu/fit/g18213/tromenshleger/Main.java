package ru.nsu.fit.g18213.tromenshleger;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start, finish;

        final int ELNUM = 500000;
        List<Integer> numbersList = Collections.nCopies(ELNUM, 16769023);
        int[] numbers = numbersList.stream().mapToInt(i -> i).toArray();

        for (int i = 1; i < 13; i++) {
            start = System.currentTimeMillis();
            FindNotPrimes.threadPoolComputing(numbers, i);
            finish = System.currentTimeMillis();
            System.out.println("Time: " + (finish - start));
        }
    }
}
