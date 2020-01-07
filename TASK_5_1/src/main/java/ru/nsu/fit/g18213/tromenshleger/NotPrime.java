package ru.nsu.fit.g18213.tromenshleger;

public class NotPrime {
    /**
     * Checks whether <code>n</code> is not prime number.
     * @param   n   the number to check
     * @return      true if the number is not prime
     *              and false otherwise
     */
    static boolean check(int n) {
        if (n < 2) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
