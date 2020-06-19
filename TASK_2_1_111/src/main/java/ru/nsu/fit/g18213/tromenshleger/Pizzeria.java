package ru.nsu.fit.g18213.tromenshleger;

import java.io.File;
import java.util.stream.IntStream;

/**
 * The class contains the main method for pizzeria to start working
 */
public class Pizzeria {
    private static final int WAITING_TIME_MILLISECONDS = 3000;

    private final Employees employees;
    private final Chefs chefs;
    private final Couriers couriers;
    private final PizzeriaData pizzeriaData;
    private final OrdersQueue ordersQueue;
    private final Warehouse warehouse;

    /**
     * Initializes the pizzeria with the given employees parameters and warehouse capacity.
     *
     * @param employeesParameters parameters of the chefs and couriers
     * @param warehouseCapacity capacity of the warehouse
     */
    public Pizzeria(File employeesParameters, int warehouseCapacity) {
        JSONParser reader = new JSONParser();
        employees = reader.readParameters(employeesParameters);
        pizzeriaData = new PizzeriaData();
        warehouse = new Warehouse(warehouseCapacity);
        ordersQueue = new OrdersQueue();
        chefs = new Chefs();
        couriers = new Couriers();
    }

    /**
     * Places orders, processes them, closes the pizzeria, and returns the {@code
     * pizzeriaData} object.
     *
     * @param numOfOrders total number of orders
     * @return the {@code pizzeriaData} object
     */
    public PizzeriaData start(int numOfOrders) {
        chefs.run(employees, warehouse, ordersQueue, pizzeriaData);
        couriers.run(employees, warehouse, pizzeriaData);

        IntStream.range(0, numOfOrders).forEach(i -> order());
        closeRestaurant();

        return pizzeriaData;
    }

    private void order() {
        System.out.println( "Your order id is " + pizzeriaData.getCurrentOrderId());
        Order order = new Order(pizzeriaData.getCurrentOrderId());
        pizzeriaData.updateCurrentOrderId();
        ordersQueue.order(order);
    }

    private void closeRestaurant() {
        pizzeriaData.closeRestaurant();

        while (!ordersQueue.areThereNoOrders()) {
            try {
                Thread.sleep(WAITING_TIME_MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (FutureRes getPizzaChefsWithTheirPizzas :
                chefs.getPizzaChefsWithTheirPizzas()) {

            Chef chef = (Chef) getPizzaChefsWithTheirPizzas.object;

            if (chef.isWaitingForOrder()) {
                getPizzaChefsWithTheirPizzas.future.cancel(true);
            }
        }

        while (!pizzeriaData.areAllChefsFinishedWork()
                || !pizzeriaData.areAllCouriersFinishedWork()) {

            try {
                Thread.sleep(WAITING_TIME_MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

