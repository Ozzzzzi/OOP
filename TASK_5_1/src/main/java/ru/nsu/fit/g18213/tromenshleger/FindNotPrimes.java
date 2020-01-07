package ru.nsu.fit.g18213.tromenshleger;

import java.util.Arrays;
import java.util.concurrent.*;

public class FindNotPrimes {
    /**
     * Finds whether there is at least one not prime number in the
     * given <code>numArray</code> using sequantial computing.
     *
     * @param  numArray  the numbers array
     * @return           true if there is at least one not prime number
     *                   and false otherwise
     */
    public static boolean sequentialComputing(int[] numArray) {
        return Arrays.stream(numArray).anyMatch(NotPrime::check);
    }

    /**
     * Finds whether there is at least one not prime number in the
     * given <code>numArray</code> using parallel computing.
     *
     * @param  numArray  the numbers array
     * @return           true if there is at least one not prime number
     *                   and false otherwise
     */

    public static boolean parallelComputing(int[] numArray) {
        return Arrays.stream(numArray).parallel().anyMatch(NotPrime::check);
    }

    /**
     * Finds whether there is at least one not prime number in the
     * given <code>numArray</code> using ExecutorService.
     *
     * @param  numArray  the numbers array
     * @return           true if there is at least one not prime number
     *                   and false otherwise
     */
    @SuppressWarnings("unchecked")
    public static boolean threadPoolComputing(int[] numArray, int threadNum) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(threadNum);
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        NotPrimeTask[] workers = new NotPrimeTask[threadNum];
        Future<Boolean>[] res = new Future[threadNum];

        int len = numArray.length;
        int step = len / threadNum;
        int start = 0;
        int end = 0;

        for(int i = 0; i != threadNum; i++) {
            if(start + step < len) {
                end += step;
            }
            else {
                end = len - 1;
            }

            workers[i] = new NotPrimeTask(numArray, start, end, latch);
            start = ++end;
        }

        for (int i = 0; i < threadNum; i++) {
            res[i] = executor.submit(workers[i]);
        }
        executor.shutdown();

        try {
            latch.await();
        } catch (InterruptedException ex) {
            executor.shutdownNow();
        }

        for(int i = 0; i != res.length; i++)
            if (res[i].get()) {
                return true;
            }
        return false;
    }
}

