package com.tytarenko.airline;

import com.tytarenko.aircraft.Aircraft;
import com.tytarenko.aircraft.PassengerAircraft;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.Comparator.comparingDouble;

/**
 * @author Vladyslav Tytarenko
 * Class describe airline and functions.
 * @see com.tytarenko.airline.Airline implemented by AirlineImpl class
 */
public class AirlineImpl implements Airline {

    private List<Aircraft> aircraftList;
    private double totalAircraftCapacity;
    private int totalPassengerCapacity;
    private double totalCarryingCapacity;

    /**
     * @param aircraftList initializes variable aircraftList.
     *                     Variables totalAircraftCapacity, totalPassengerCapacity,
     *                     totalCarryingCapacity counted from aircraftList.
     */
    public AirlineImpl (@NonNull List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
        totalAircraftCapacity = aircraftList.stream()
                .reduce(0.0, (x,y) -> x + y.getCapacity(), (x,y) -> x + y);
        totalCarryingCapacity = aircraftList.stream()
                .reduce(0.0, (x,y) -> x + y.getCarryingCapacity(), (x,y) -> x + y);
        totalPassengerCapacity = 0;
        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getClass().equals(PassengerAircraft.class))
                totalPassengerCapacity += ((PassengerAircraft)aircraft).getPassengerCapacity();
        }
    }

    /**
     * Adding new aircraft to airline.
     * @param aircraft object of class which implements Aircraft interface
     *                 and describe aircraft
     * @see com.tytarenko.aircraft.Aircraft
     *
     */
    public void addAircraft(@NonNull Aircraft aircraft) {
        aircraftList.add(aircraft);
        totalCarryingCapacity += aircraft.getCarryingCapacity();
        totalAircraftCapacity += aircraft.getCapacity();
        if (aircraft.getClass().equals(PassengerAircraft.class))
            totalPassengerCapacity += ((PassengerAircraft)aircraft).getPassengerCapacity();
    }

    /**
     * Remove aircraft from airline.
     * @param id identification number of aircraft in airline
     * @exception IllegalArgumentException throwed if parameter id is less than 0
     */
    public void removeAicraft(@NonNull int id) {
        if (id < 0)
            throw new IllegalArgumentException();
        Aircraft aircraft = aircraftList.remove(id);
        totalAircraftCapacity -= aircraft.getCapacity();
        totalCarryingCapacity -= aircraft.getCarryingCapacity();
        if (aircraft.getClass().equals(PassengerAircraft.class))
            totalPassengerCapacity -= ((PassengerAircraft)aircraft).getPassengerCapacity();
    }

    /**
     * @return List<Aircraft> aircraft sorted by increasing of flight range
     */
    public List<Aircraft> getAircraftSortedByFlightRange() {
        return aircraftList.stream()
                .sorted(comparingDouble(g -> g.getFlightRange() )).collect(Collectors.toList());
    }

    /**
     * @param min minimum fuel consumption
     * @param max maximum fuel consumption
     * @return aircrafts and its fuel consumption between two values
     * @exception IllegalArgumentException throws, if parameter min or max is less/equals to 0
     * and max is less/equals to min.
     */
    public List<Aircraft> getAircrafByFuelConsumtionRange(@NonNull double min, @NonNull double max) {
        if (min >= max || min <= 0)
            throw new IllegalArgumentException();
        return aircraftList.stream().filter(x -> x.getFuelConsumption() >= min && x.getFuelConsumption() <= max )
                .collect(Collectors.toList());
    }

    /**
     * @return total passenger capacity of airline
     */
    public int getTotalPassengerCapacity() {
        return totalPassengerCapacity;
    }

    /**
     * @return not sorted list of airline's aicrafts
     */
    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    /**
     * @return total aircrafts capacity
     */
    public double getTotalAircraftCapacity() {
        return totalAircraftCapacity;
    }

    /**
     * @return total carrying capacity of all airline's aicrafts
     */

    public double getTotalCarryingCapacity() {
        return totalCarryingCapacity;
    }

}
