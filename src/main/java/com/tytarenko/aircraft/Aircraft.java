package com.tytarenko.aircraft;

/**
 * @author Vladyslav Tytarenko
 * This interface is the basis for all classes that describe the aircraft.
 *
 */
public interface Aircraft {

    /**
     * @return  capacity value of aircraft in m3
     */
    double getCapacity();

    /**
     * @return fuel consumption in liters per hour
     */
    double getFuelConsumption();
    double getFlightRange();
    double getCarryingCapacity();
}
