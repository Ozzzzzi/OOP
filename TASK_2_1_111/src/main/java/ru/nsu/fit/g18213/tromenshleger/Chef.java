package ru.nsu.fit.g18213.tromenshleger;

import com.fasterxml.jackson.annotation.JsonProperty;

class Chef implements Runnable {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("cookingTime")
    private final int cookingTime;

    private boolean waitingForOrder;

    private Warehouse warehouse;
    private OrdersQueue ordersQueue;
    private PizzeriaData pizzeriaData;

    Chef(@JsonProperty("id") int id, @JsonProperty("cookingTime") int cookingTime) {
        this.id = id;
        this.cookingTime = cookingTime;
        waitingForOrder = false;
    }

    boolean isWaitingForOrder() {
        return waitingForOrder;
    }

    void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    void setOrdersQueue(OrdersQueue ordersQueue) {
        this.ordersQueue = ordersQueue;
    }

    void setPizzeriaData(PizzeriaData pizzeriaData) {
        this.pizzeriaData = pizzeriaData;
    }

    @Override
    public synchronized void run() {

        while (!pizzeriaData.isPizzeriaClosed()
                || !ordersQueue.areThereNoOrders()) {

            Order currentOrder;

                this.waitingForOrder = true;
                if (pizzeriaData.isPizzeriaClosed() && ordersQueue.areThereNoOrders()) {
                    break;
                }

                currentOrder = ordersQueue.takeOrder();
                this.waitingForOrder = false;

            System.out.println(
                    "Chef #" + id + " is making a pizza. Order #" + currentOrder.getId() + ".");

            try {
                Thread.sleep(cookingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Chef #" + id + " just finished making order #" + currentOrder.getId());
            warehouse.putItemAwayInWarehouse(currentOrder);
        }
        pizzeriaData.endShiftForPizzaChef();
        System.out.println("Chef #" + id + " has finished working.");
    }

    int getId() {
        return id;
    }

    int getCookingTime() {
        return cookingTime;
    }
}