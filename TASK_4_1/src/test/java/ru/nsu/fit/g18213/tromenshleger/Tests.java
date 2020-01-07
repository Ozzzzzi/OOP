package ru.nsu.fit.g18213.tromenshleger;

import org.junit.Assert;
import org.junit.Test;

import java.util.InputMismatchException;

public class Tests {

    /**
     * The first test from the task
     */
    @Test
    public void test1() {
        Calc test = new Calc();
        double res = test.calculate("sin + - 1 2 1");
        Assert.assertEquals(0, Double.compare(0.0, res));
    }

    /**
     * Tests all available operations
     */
    @Test
    public void test2() {
        Calc test = new Calc();
        double res = test.calculate("sin sqrt pow + * - log / cos 0 2 0.25 3 5 10 2");
        Assert.assertEquals(0, Double.compare(-0.9589242746631385, res));
    }

    /**
     * Not enough arguments
     */
    @Test(expected = InputMismatchException.class)
    public void test3() {
        Calc test = new Calc();
        double res = test.calculate("sin sqrt pow + * - log / cos 0 2 0.25 3 5 10");
    }

    /**
     * Too many arguments
     */
    @Test(expected = InputMismatchException.class)
    public void test4() {
        Calc test = new Calc();
        double res = test.calculate("sin sqrt pow + * - log / cos 0 2 0.25 3 5 10 11 3");
    }

    /**
     * Empty expression
     */
    @Test(expected = InputMismatchException.class)
    public void test5() {
        Calc test = new Calc();
        double res = test.calculate(" ");
    }

    /**
     * Unknown functions
     */
    @Test(expected = InputMismatchException.class)
    public void test6() {
        Calc test = new Calc();
        double res = test.calculate("tan cos 5");
    }

    /**
     * No functions in the expression
     */
    @Test(expected = InputMismatchException.class)
    public void test7() {
        Calc test = new Calc();
        double res = test.calculate("5 4 3 2 1");
    }

    /**
     * Mo arguments in the expression
     */
    @Test(expected = InputMismatchException.class)
    public void test8() {
        Calc test = new Calc();
        double res = test.calculate("sin cos + -");
    }

    /**
     * Negative sqrt
     */
    @Test(expected = IllegalArgumentException.class)
    public void test9() {
        Calc test = new Calc();
        double res = test.calculate("sqrt -5");
    }

    /**
     * Division by zero
     */
    @Test(expected = IllegalArgumentException.class)
    public void test10() {
        Calc test = new Calc();
        double res = test.calculate("/ 2 0");
    }

    /**
     * log with base 1
     */
    @Test(expected = IllegalArgumentException.class)
    public void test11() {
        Calc test = new Calc();
        double res = test.calculate("log 1 10");
    }

    /**
     * Negative log
     */
    @Test(expected = IllegalArgumentException.class)
    public void test12() {
        Calc test = new Calc();
        double res = test.calculate("log 10 -10");
    }
}
