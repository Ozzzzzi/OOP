package ru.nsu.fit.g18213.tromenshleger;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File Param = new File("src/main/resources/Employees.json");

        Pizzeria xarakiri = new Pizzeria(Param, 10);
        xarakiri.start(4);
    }
}
