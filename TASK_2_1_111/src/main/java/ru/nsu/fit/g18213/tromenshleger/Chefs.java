package ru.nsu.fit.g18213.tromenshleger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Chefs {
    private final List<FutureRes> pizzaChefsWithTheirPizzas;

    Chefs() {
        this.pizzaChefsWithTheirPizzas = new ArrayList<>();
    }

    void run(
            Employees employees,
            Warehouse warehouse,
            OrdersQueue ordersQueue,
            PizzeriaData pizzeriaData) {

        pizzeriaData.setNumOfChefs(employees.chefs.length);
        ExecutorService executorService = Executors.newFixedThreadPool(employees.chefs.length);

        for (Chef chef : employees.chefs) {
            chef.setPizzeriaData(pizzeriaData);
            chef.setWarehouse(warehouse);
            chef.setOrdersQueue(ordersQueue);

            pizzaChefsWithTheirPizzas.add(
                    new FutureRes(chef, executorService.submit(chef)));
        }
    }

    List<FutureRes> getPizzaChefsWithTheirPizzas() {
        return pizzaChefsWithTheirPizzas;
    }
}
