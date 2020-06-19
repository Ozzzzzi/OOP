package ru.nsu.fit.g18213.tromenshleger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Couriers {
    private final List<Future<?>> orders;

    Couriers() {
        orders = new ArrayList<>();
    }

    void run(
            Employees employees,
            Warehouse warehouse,
            PizzeriaData pizzeriaData) {

        pizzeriaData.setNumOfCouriers(employees.couriers.length);
        ExecutorService executor = Executors.newFixedThreadPool(employees.couriers.length);

        for (Courier courier : employees.couriers) {
            courier.setPizzeriaData(pizzeriaData);
            courier.setWarehouse(warehouse);

            Future<?> future = executor.submit(courier);
            orders.add(future);
        }
    }

    List<Future<?>> getOrders() {
        return orders;
    }
}