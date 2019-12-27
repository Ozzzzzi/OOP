package ru.nsu.fit.g18213.tromenshleger;
import java.util.concurrent.*;

/**
 * This class implements the same NotPrime function
 * but in a form of a callable task for further
 * usage in ExecutorService.
 */

public class NotPrimeTask implements Callable<Boolean>{

    private int[] numArray;

    public NotPrimeTask(int[] numArray) {
        this.numArray = new int[500001];
        System.arraycopy(numArray, 0, this.numArray, 0, numArray.length);
    }

    public Boolean call() {
        for (Integer num : numArray) {
            if (num < 2) {
                return true;
            }
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
