package ru.nsu.fit.g18213.tromenshleger;

/**
 * The class represents the statistics of the pizzeria and other important data.
 */
public class PizzeriaData {

    private int numOfChefs;
    private int numOfCouriers;
    private int numOfChefsFinishedWork;
    private int numOfCouriersFinishedWork;
    private int currentOrderId;
    private int numOfCompletedOrders;
    private boolean pizzeriaIsClosed;

    /** Zeroes all the statistics and data. */
    public PizzeriaData() {
        currentOrderId = 0;
        numOfCompletedOrders = 0;
        numOfChefsFinishedWork = 0;
        numOfCouriersFinishedWork = 0;
        pizzeriaIsClosed = false;
    }

    /**
     * Returns {@code true} if the restaurant is closed.
     *
     * @return {@code true} if the restaurant is closed
     */
    public boolean isPizzeriaClosed() {
        return pizzeriaIsClosed;
    }

    /**
     * Returns {@code true} if all chefs finished their work.
     *
     * @return {@code true} if all chefs finished their work
     */
    public boolean areAllChefsFinishedWork() {
        return numOfChefs == numOfChefsFinishedWork;
    }

    /**
     * Returns {@code true} if all couriers finished their work.
     *
     * @return {@code true} if all couriers finished their work
     */
    public boolean areAllCouriersFinishedWork() {
        return numOfCouriers == numOfCouriersFinishedWork;
    }

    /**
     * Returns current order ID.
     *
     * @return current order ID
     */
    public int getCurrentOrderId() {
        return currentOrderId;
    }

    void updateCurrentOrderId() {
        currentOrderId++;
    }

    void closeRestaurant() {
        pizzeriaIsClosed = true;
    }

    void completeOrder() {
        numOfCompletedOrders++;
    }

    void setNumOfChefs(int numOfChefs) {
        this.numOfChefs = numOfChefs;
    }

    void setNumOfCouriers(int numOfCouriers) {
        this.numOfCouriers = numOfCouriers;
    }

    void endShiftForPizzaChef() {
        numOfChefsFinishedWork++;
    }

    void endShiftForCouriers() {
        numOfCouriersFinishedWork++;
    }
}

