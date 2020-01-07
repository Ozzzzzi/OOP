package ru.nsu.fit.g18213.tromenshleger.Abstract;

public abstract class UnaryOperation extends Operation {

    /**
     * The constructor of operation with arity 1.
     */
    public UnaryOperation() {
        super(1);
    }

    public abstract double execute();

}