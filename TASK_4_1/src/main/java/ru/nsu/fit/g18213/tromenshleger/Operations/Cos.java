package ru.nsu.fit.g18213.tromenshleger.Operations;

import ru.nsu.fit.g18213.tromenshleger.Abstract.UnaryOperation;

public class Cos extends UnaryOperation {

    public static final String sign = "cos";

    @Override
    public double execute() {
        clearArgs();
        return Math.cos(getArg(0));
    }
}
