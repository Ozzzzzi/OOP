package ru.nsu.fit.g18213.tromenshleger;

import java.util.concurrent.LinkedBlockingQueue;

class OrdersQueue {
    private final LinkedBlockingQueue<Order> pendingOrders;

    OrdersQueue() {
        pendingOrders = new LinkedBlockingQueue<>();
    }

    void order(Order order) {
        try {
            pendingOrders.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Order takeOrder() {
        try {
            return pendingOrders.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    boolean areThereNoOrders() {
        return pendingOrders.isEmpty();
    }
}