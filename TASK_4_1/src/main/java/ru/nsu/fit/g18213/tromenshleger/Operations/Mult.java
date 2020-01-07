package ru.nsu.fit.g18213.tromenshleger.Operations;

import ru.nsu.fit.g18213.tromenshleger.Abstract.BinaryOperation;

public class Mult extends BinaryOperation {

    public static final String sign = "*";

    @Override
    public double execute() {
        clearArgs();
        return getArg(0) * getArg(1);
    }
}
