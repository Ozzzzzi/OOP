package ru.nsu.fit.g18213.tromenshleger;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    public static boolean threadPoolComputing(int[] numArray) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        NotPrimeTask task = new NotPrimeTask(numArray);
        Future<Boolean> future = service.submit(task);
        return future.get();
        service.shutdown();
    }
}
