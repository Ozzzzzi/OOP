package ru.nsu.fit.g18213.tromenshleger.Abstract;

public abstract class BinaryOperation extends Operation {

    /**
     * The constructor of operation with arity 2.
     */
    public BinaryOperation() {
        super(2);
    }

    public abstract double execute();

}
