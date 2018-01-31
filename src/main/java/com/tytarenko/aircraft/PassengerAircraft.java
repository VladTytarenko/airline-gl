package com.tytarenko.aircraft;

import lombok.NonNull;

/*
 * @author Vladyslav Tytarenko
 */
public class PassengerAircraft extends AircraftImpl {

    private int passengerCapacity;

    public PassengerAircraft(@NonNull long id, @NonNull String model, @NonNull double flightRange, @NonNull double capacity,
                             @NonNull double carryingCapacity, @NonNull double fuelConsumption, @NonNull int passengerCapacity) {
        super(id, model, flightRange, capacity, carryingCapacity, fuelConsumption);
        if (passengerCapacity <= 0)
            throw new IllegalArgumentException();
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | passenger capacity: " + passengerCapacity;
    }
}
