package ru.nsu.fit.g18213.tromenshleger.Operations;

import ru.nsu.fit.g18213.tromenshleger.Abstract.UnaryOperation;

public class Sqrt extends UnaryOperation {

    public static final String sign = "sqrt";

    @Override
    public double execute() {
        clearArgs();
        if (getArg(0) < 0) {
            throw new IllegalArgumentException("No complex numbers here!");
        }
        return Math.sqrt(getArg(0));
    }
}
