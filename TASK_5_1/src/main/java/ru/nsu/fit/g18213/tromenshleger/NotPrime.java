package ru.nsu.fit.g18213.tromenshleger;

public class NotPrime {

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

