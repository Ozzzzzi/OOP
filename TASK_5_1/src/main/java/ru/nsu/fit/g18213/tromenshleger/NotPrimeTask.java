package ru.nsu.fit.g18213.tromenshleger;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class NotPrimeTask implements Callable<Boolean> {

    private int[] numArray;
    private int start;
    private int end;
    private CountDownLatch latch;

    public NotPrimeTask(int[] numArray, int start, int end, CountDownLatch latch) {
        this.numArray = numArray;
        this.start = start;
        this.end = end;
        this.latch = latch;
    }

    @Override
    public Boolean call() {
        for (int i = start; i <= end; i++) {
            if (NotPrime.check(numArray[i])) {
                latch.countDown();
                return true;
            }
        }
        latch.countDown();
        return false;
    }

}