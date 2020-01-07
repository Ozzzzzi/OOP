package ru.nsu.fit.g18213.tromenshleger.Operations;

import ru.nsu.fit.g18213.tromenshleger.Abstract.BinaryOperation;

public class Log extends BinaryOperation {

    public static final String sign = "log";

    @Override
    public double execute() {
        clearArgs();
        if (getArg(0) <= 0 || getArg(0) == 1 || getArg(1) <= 0 ) {
            throw new IllegalArgumentException("Not possible to define logarithm");
        }
        return Math.log(getArg(1)) / Math.log(getArg(0));
    }
}
