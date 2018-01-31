package com.tytarenko.airline;

import com.tytarenko.aircraft.Aircraft;

import java.util.List;

/**
 * @author Vladyslav Tytarenko
 */
public interface Airline {

    void addAircraft(Aircraft aircraft);
    void removeAicraft(int id);
    List<Aircraft> getAircraftList();
    double getTotalAircraftCapacity();
    List<Aircraft> getAircraftSortedByFlightRange();
    List<Aircraft> getAircrafByFuelConsumtionRange(double min, double max);
    int getTotalPassengerCapacity();
    double getTotalCarryingCapacity();

}
