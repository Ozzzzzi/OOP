package ru.nsu.fit.g18213.tromenshleger;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class Tests {

    public long start, finish;

    public int[] numbers1 = {6, 8, 7, 13, 9, 4};

    @Test
    public void sequential1() {
        start = System.currentTimeMillis();
        Assert.assertTrue(FindNotPrimes.sequentialComputing(numbers1));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }

    @Test
    public void parallel1() {
        start = System.currentTimeMillis();
        Assert.assertTrue(FindNotPrimes.parallelComputing(numbers1));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }

    @Test
    public void executor1() throws ExecutionException, InterruptedException {
        start = System.currentTimeMillis();
        Assert.assertTrue(FindNotPrimes.threadPoolComputing(numbers1));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }

    public int[] numbers2 = {6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053, 6998052};

    @Test
    public void sequential2() {
        start = System.currentTimeMillis();
        Assert.assertTrue(FindNotPrimes.sequentialComputing(numbers2));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }

    @Test
    public void parallel2() {
        start = System.currentTimeMillis();
        Assert.assertTrue(FindNotPrimes.parallelComputing(numbers2));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }

    @Test
    public void executor2() throws ExecutionException, InterruptedException {
        start = System.currentTimeMillis();
        Assert.assertTrue(FindNotPrimes.threadPoolComputing(numbers2));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }

    public static final int ELNUM = 500000;
    public List<Integer> numbersList = Collections.nCopies(ELNUM, 16769023);
    public int[] numbers3 = numbersList.stream().mapToInt(i -> i).toArray();

    @Test
    public void sequential3() {
        start = System.currentTimeMillis();
        Assert.assertFalse(FindNotPrimes.sequentialComputing(numbers3));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }

    @Test
    public void parallel3() {
        start = System.currentTimeMillis();
        Assert.assertFalse(FindNotPrimes.parallelComputing(numbers3));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }

    @Test
    public void executor3() throws ExecutionException, InterruptedException {
        start = System.currentTimeMillis();
        Assert.assertTrue(FindNotPrimes.threadPoolComputing(numbers3));
        finish = System.currentTimeMillis();

        System.out.println("Time: " + (finish - start));
    }
}