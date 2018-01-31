package com.tytarenko.aircraft;

import lombok.NonNull;

/**
 * @author Vladyslav Tytarenko
 * Class describes aircraft and implements @see com.tytarenko.aircraft.Aircraft
 */
public class AircraftImpl implements Aircraft {

    private long serialNumber;
    private String model;
    private double flightRange;
    private double capacity; // об'ем
    private double carryingCapacity; // вантажопідйомність
    private double fuelConsumption;

    public AircraftImpl(@NonNull long serialNumber, @NonNull String model, @NonNull double flightRange, @NonNull double capacity,
                        @NonNull double carryingCapacity, @NonNull double fuelConsumption) {
        if (serialNumber < 0 || flightRange <= 0 || capacity <= 0 ||
                carryingCapacity <= 0 || fuelConsumption <= 0 )
            throw new IllegalArgumentException();
        this.serialNumber = serialNumber;
        this.model = model;
        this.flightRange = flightRange;
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(@NonNull double capacity) {
        if (capacity < 0) throw new IllegalArgumentException();
        this.capacity = capacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(@NonNull double fuelConsumption) {
        if (fuelConsumption <= 0) throw new IllegalArgumentException();
        this.fuelConsumption = fuelConsumption;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(@NonNull double flightRange) {
        if (flightRange <= 0) throw new IllegalArgumentException();
        this.flightRange = flightRange;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String toString() {
        return  "\nserial number: " + serialNumber +
                " | model: " + model +
                " | capacity: " + capacity +
                " | carrying capacity:" + carryingCapacity +
                " | fuel consumption: " + fuelConsumption +
                " | flight range: " + flightRange;
    }
}
