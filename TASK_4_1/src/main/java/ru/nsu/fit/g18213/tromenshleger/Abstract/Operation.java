package ru.nsu.fit.g18213.tromenshleger.Abstract;

public abstract class Operation {

    public final int arity;
    private double[] args;
    private int cnt;

    /**
     * The constructor sets the arity of operation (for now can be 1 or 2),
     * sets the counter which is used for arguments navigation and creates an array
     * for arguments.
     */
    public Operation(int arity) {
        this.arity = arity;
        this.cnt = 0;
        this.args = new double[arity];
    }

    /**
     * Sets arguments to calculate.
     *
     * @param arg the next argument to set
     */
    public void setArg(double arg) {
        args[cnt++] = arg;
    }

    /**
     * Gets arguments for check possibility.
     *
     * @param num the num of argument
     */
    public double getArg(int num) {
        return args[num];
    }

    /**
     * Implements the execution for every specific operation
     */
    public abstract double execute();

    /**
     * Gets arity for execution purposes.
     *
     * @return the arity of operation
     */
    public int getArity() {
        return arity;
    }

    /**
     * Resets the arguments counter for the next
     * calculation.
     */
    public void clearArgs() {
        cnt = 0;
    }

}
