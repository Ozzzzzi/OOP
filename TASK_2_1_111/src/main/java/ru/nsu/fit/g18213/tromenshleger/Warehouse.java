package ru.nsu.fit.g18213.tromenshleger;

import java.util.concurrent.TimeUnit;

class Warehouse {
    private static NewArrayBlockingQueue<Order> itemsInWarehouse;

    Warehouse(int capacity) {
        itemsInWarehouse = new NewArrayBlockingQueue<>(capacity, true);
    }

    void putItemAwayInWarehouse(Order order) {
        try {
            itemsInWarehouse.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Order pickItemForDelivery(int milliseconds) throws InterruptedException {
        return itemsInWarehouse.poll(milliseconds, TimeUnit.MILLISECONDS);
    }

    int numOfItemsInWarehouse() {
        return itemsInWarehouse.size();
    }
}
