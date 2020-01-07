package ru.nsu.fit.g18213.tromenshleger.Operations;

import ru.nsu.fit.g18213.tromenshleger.Abstract.UnaryOperation;

public class Sin extends UnaryOperation {

    public static final String sign = "sin";

    @Override
    public double execute() {
        clearArgs();
        return Math.sin(getArg(0));
    }
}
