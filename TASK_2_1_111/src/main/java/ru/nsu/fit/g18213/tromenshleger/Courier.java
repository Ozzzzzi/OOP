package ru.nsu.fit.g18213.tromenshleger;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Courier implements Runnable {
    private static final int WAITING_TIME_MILLISECONDS = 1000;

    @JsonProperty("id")
    private final int id;

    @JsonProperty("howManyPizzasCanCarry")
    private final int numOfPizzasCanCarry;

    private final List<Order> bag;

    @JsonProperty("deliveryTime")
    private final int deliveryTime;

    private Warehouse warehouse;
    private PizzeriaData pizzeriaData;

    Courier(
            @JsonProperty("id") int id,
            @JsonProperty("deliveryTime") int deliveryTime,
            @JsonProperty("howManyPizzasCanCarry") int numOfPizzasCanCarry) {
        this.id = id;
        this.deliveryTime = deliveryTime;
        this.numOfPizzasCanCarry = numOfPizzasCanCarry;
        this.bag = new ArrayList<>();
    }

    void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    void setPizzeriaData(PizzeriaData pizzeriaData) {
        this.pizzeriaData = pizzeriaData;
    }

    @Override
    public synchronized void run() {
        while (!pizzeriaData.isPizzeriaClosed()
                || !(warehouse.numOfItemsInWarehouse() == 0
                && pizzeriaData.areAllChefsFinishedWork())) {

            boolean isClosed = false;

            try {
                if (pizzeriaData.isPizzeriaClosed()
                        && warehouse.numOfItemsInWarehouse() == 0
                        && pizzeriaData.areAllChefsFinishedWork()) {
                    break;
                }

                for (int i = 0; i < numOfPizzasCanCarry; i++) {
                    Order order = null;
                    if (bag.size() != 0) {
                        try {
                            order = warehouse.pickItemForDelivery(WAITING_TIME_MILLISECONDS);
                            if (order == null) {
                                 break;
                            }
                            bag.add(order);
                            System.out.println("Courier #" + id + " took order #" + order.getId());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        while (bag.size() == 0) {
                            if (pizzeriaData.isPizzeriaClosed()
                                    && warehouse.numOfItemsInWarehouse() == 0
                                    && pizzeriaData.areAllChefsFinishedWork()) {
                                isClosed = true;
                                break;
                            }
                            order = warehouse.pickItemForDelivery(WAITING_TIME_MILLISECONDS);
                            if (order != null) {
                                bag.add(order);
                            }
                        }
                        if (isClosed) {
                            break;
                        }

                        System.out.println("Courier #" + id + " took order #" + Objects.requireNonNull(order).getId());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (isClosed) {
                break;
            }

            try {
                for (Order order : bag) {
                    Thread.sleep(deliveryTime);
                    pizzeriaData.completeOrder();
                    System.out.println(
                            "Courier #" + id + " delivered your pizza");
                }
                System.out.println("Courier #" + id + " delivered all the orders.");
                Thread.sleep(deliveryTime);
                bag.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pizzeriaData.endShiftForCouriers();
        System.out.println("Courier #" + id + " has finished his shift.");
    }

    int getId() {
        return id;
    }

    int getDeliveryTime() {
        return deliveryTime;
    }

    int getNumOfPizzasCanCarry() {
        return numOfPizzasCanCarry;
    }
}