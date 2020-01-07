package ru.nsu.fit.g18213.tromenshleger.Operations;

import ru.nsu.fit.g18213.tromenshleger.Abstract.BinaryOperation;

public class Pow extends BinaryOperation {

    public static final String sign = "pow";

    @Override
    public double execute() {
        clearArgs();
        return Math.pow(getArg(0), getArg(1));
    }
}