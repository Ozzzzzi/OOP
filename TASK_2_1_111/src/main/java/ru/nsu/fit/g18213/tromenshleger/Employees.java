package ru.nsu.fit.g18213.tromenshleger;

import com.fasterxml.jackson.annotation.JsonProperty;

class Employees {

    @JsonProperty("pizzaChefs")
    final Chef[] chefs;

    @JsonProperty("deliveryWorkers")
    final Courier[] couriers;

    Employees(
            @JsonProperty("pizzaChefs") Chef[] chefs,
            @JsonProperty("deliveryWorkers") Courier[] couriers) {

        this.chefs = chefs;
        this.couriers = couriers;
    }
}

