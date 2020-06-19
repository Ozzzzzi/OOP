package ru.nsu.fit.g18213.tromenshleger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import org.junit.jupiter.api.Test;

public class PizzeriaTest {

    @Test
    public void closePizzeriaAllCouriersShouldFinish() {

        PizzeriaData pizzeriaData = new PizzeriaData();
        Warehouse warehouse = new Warehouse(10);

        Courier courier1 = new Courier(1, 10000, 3);
        Courier courier2 = new Courier(2, 10000, 4);

        courier1.setPizzeriaData(pizzeriaData);
        courier1.setWarehouse(warehouse);

        courier2.setPizzeriaData(pizzeriaData);
        courier2.setWarehouse(warehouse);

        pizzeriaData.setNumOfCouriers(2);

        Thread thread1 = new Thread(courier1);
        Thread thread2 = new Thread(courier2);

        thread1.start();
        thread2.start();

        pizzeriaData.closeRestaurant();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(pizzeriaData.areAllCouriersFinishedWork());

        System.out.println();
    }

    @Test
    public void closePizzeriaAllChefsShouldFinish() {

        OrdersQueue ordersQueue = new OrdersQueue();
        PizzeriaData pizzeriaData = new PizzeriaData();
        Warehouse warehouse = new Warehouse(10);

        Chef chef1 = new Chef(1, 10000);
        Chef chef2 = new Chef(2, 10000);

        chef1.setPizzeriaData(pizzeriaData);
        chef1.setWarehouse(warehouse);
        chef1.setOrdersQueue(ordersQueue);

        chef2.setPizzeriaData(pizzeriaData);
        chef2.setWarehouse(warehouse);
        chef2.setOrdersQueue(ordersQueue);

        pizzeriaData.setNumOfChefs(2);

        Thread thread1 = new Thread(chef1);
        Thread thread2 = new Thread(chef2);

        thread1.start();
        thread2.start();

        ordersQueue.order(new Order(1));
        ordersQueue.order(new Order(2));

        pizzeriaData.closeRestaurant();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(pizzeriaData.areAllChefsFinishedWork());

        System.out.println();
    }

    @Test
    public void pizzeriaClosing() {

        File employeesParameters = new File("src/main/resources/Employees.json");
        Pizzeria pizzeria = new Pizzeria(employeesParameters, 10);
        PizzeriaData pizzeriaData = pizzeria.start(4);

        assertTrue(pizzeriaData.areAllChefsFinishedWork());
        assertTrue(pizzeriaData.areAllCouriersFinishedWork());
        assertTrue(pizzeriaData.isPizzeriaClosed());

        System.out.println();
    }

    @Test
    public void checkChefsAndCouriers() {
        Warehouse warehouse = new Warehouse(10);
        OrdersQueue ordersQueue = new OrdersQueue();
        PizzeriaData pizzeriaData = new PizzeriaData();
        Couriers couriers = new Couriers();
        Chefs chefs = new Chefs();

        JSONParser jsonParser = new JSONParser();
        File employeesParameters = new File("src/main/resources/Employees.json");
        Employees employees = jsonParser.readParameters(employeesParameters);

        chefs.run(employees, warehouse, ordersQueue, pizzeriaData);
        couriers.run(employees, warehouse, pizzeriaData);

        Chef chef;

        int numOfPizzaChefs = 0;
        for (FutureRes a : chefs.getPizzaChefsWithTheirPizzas()) {
            numOfPizzaChefs++;
            chef = (Chef) a.object;
            assertTrue(chef.getId() >= 1);
        }

        assertEquals(3, numOfPizzaChefs);
        assertEquals(5, couriers.getOrders().size());
    }
}