package ru.nsu.fit.g18213.tromenshleger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calc calc = new Calc();

        while (true) {
            System.out.println("Write an expression:");
            String expr = scan.nextLine();
            if (expr.equals("0")) {
                break;
            } else {
                System.out.println("Result: " + calc.calculate(expr));
            }
        }
    }
}
