package ru.nsu.fit.g18213.tromenshleger.Operations;

import ru.nsu.fit.g18213.tromenshleger.Abstract.BinaryOperation;

public class Div extends BinaryOperation {

    public static final String sign = "/";

    @Override
    public double execute() {
        clearArgs();
        if (getArg(1) == 0) {
            throw new IllegalArgumentException("No division by zero here!");
        }
        return getArg(0) / getArg(1);
    }
}
