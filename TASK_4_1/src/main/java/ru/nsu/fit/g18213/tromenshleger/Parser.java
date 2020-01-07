package ru.nsu.fit.g18213.tromenshleger;

import ru.nsu.fit.g18213.tromenshleger.Abstract.Operation;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Stack;

/**
 * The class allows to parse the expression. It also makes the most checks
 * of the expression correctness. The arguments and operations of the expression
 * are stored on two separate stacks.
 */
public class Parser {

    private final HashMap<String, Operation> avOps;
    private Stack<String> ops;
    private Stack<Double> args;

    private String[] exp;

    /**
     * The constructor gets the list of available math operations
     * in order to check the correctness of the expression and initializes
     * stacks for operations and arguments.
     */
    public Parser() {
        avOps = Mathem.getMathem();
        args = new Stack<>();
        ops = new Stack<>();
    }

    /**
     * Parses the expression and stores the arguments and operations
     * on two separate stacks. Checks the correctness of the expression.
     *
     * @param  expression               the expression to parse
     * @throws InputMismatchException   if the input is empty, or it contains no arguments,
     *                                  no functions or unknown functions.
     */
    public void parse(String expression) {
        exp = expression.split(" ");
        if (exp.length == 0) {
            throw new InputMismatchException("Empty expression");
        }
        addArgs();
        if (args.size() == 0) {
            throw new InputMismatchException("No arguments in the expression");
        }
        addOps();
        if (ops.size() == 0) {
            throw new InputMismatchException("No functions in the expression");
        }
    }

    /**
     * Returns stack with operations
     */
    public Stack getOperations() {
       return ops;
    }

    /**
     * Returns stack with arguments
     */
    public Stack<Double> getArgs() {
        return args;
    }

    /**
     * Gets all the arguments from the expression and
     * puts it on stack.
     */
    private void addArgs() {
        int cnt = exp.length - 1;
        while (cnt > -1) {
            try {
                args.push(Double.parseDouble(exp[cnt--]));
            } catch (Exception NumberFormatException) {
                break;
            }
        }
    }

    /**
     * Gets all the operations from the expression and
     * puts it on stack.
     * @throws InputMismatchException   if unknown function was detected
     */
    private void addOps() {
        int cnt = 0;
        while (cnt < exp.length - args.size()) {
            if (avOps.containsKey(exp[cnt])) {
                ops.push(exp[cnt]);
                cnt++;
            } else {
                throw new InputMismatchException("Unknown function");
            }
        }
    }
}
