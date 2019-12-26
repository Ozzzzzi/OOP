package ru.nsu.fit.g18213.tromenshleger;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FindNotPrimes {

    public static boolean sequentialComputing(int[] numArray) {
        return Arrays.stream(numArray).anyMatch(NotPrime::check);
    }

    public static boolean parallelComputing(int[] numArray) {
        return Arrays.stream(numArray).parallel().anyMatch(NotPrime::check);
    }

    public static boolean threadPoolComputing(int[] numArray) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        NotPrimeTask task = new NotPrimeTask(numArray);
        Future<Boolean> future = service.submit(task);
        return future.get();
    }
}
