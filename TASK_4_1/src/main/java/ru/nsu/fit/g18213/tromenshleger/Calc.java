package ru.nsu.fit.g18213.tromenshleger;

import ru.nsu.fit.g18213.tromenshleger.Abstract.Operation;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Stack;

/**
 * The class implements a simple prefix console calculator with
 * 7 available operations (sqrt, sin, pow, plus, mult, minus,
 * log, div, cos). The calculator checks the correctness of the expression
 * and arguments and throws a proper exception if any mismatch was found.
 */
public class Calc {

    private final HashMap<String, Operation> math;
    private Stack<Double> args;
    private Stack<String> ops;

    /**
     * The constructor gets the list of available math operations
     * and initializes stacks for the arguments and operations
     * in the expression
     */
    public Calc() {
        math = Mathem.getMathem();
        args = new Stack<>();
        ops = new Stack<>();
    }

    /**
     * The main method calculates the expression,
     * using class <code>Parser</code> to parse it.
     *
     * @param  expression               the expression to calculate
     * @return                          the result of calculations
     * @throws InputMismatchException   if the input was incorrect in some way
     *                                  and it's impossible to calculate the result
     *                                  (too many arguments, not enough arguments, etc.)
     * @throws IllegalArgumentException if the arguments for the functions are incorrect
     *                                  (division by zero, square root from negative number, etc.)
     */
    public double calculate(String expression) {
        args.clear();
        ops.clear();
        Parser parser = new Parser();
        parser.parse(expression);
        this.args = parser.getArgs();
        this.ops = parser.getOperations();
        while (!ops.isEmpty()) {
            Operation operation = math.get(ops.pop());
            for (int i = 0; i < operation.getArity(); i++) {
                try {
                    operation.setArg(args.pop());
                } catch (Exception EmptyStackException) {
                    throw new InputMismatchException("Not enough arguments");
                }
            }
            args.push(operation.execute());
        }
        if (args.size() != 1) {
            throw new InputMismatchException("Too many arguments");
        }
        return args.pop();
    }

}

