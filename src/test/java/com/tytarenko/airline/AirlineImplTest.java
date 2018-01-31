package com.tytarenko.airline;

import com.tytarenko.aircraft.Aircraft;
import com.tytarenko.aircraft.AircraftImpl;
import com.tytarenko.aircraft.PassengerAircraft;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * @author Vladyslav Tytarenko
 */
@Testable
class AirlineImplTest {

    private Airline airline;

    @BeforeEach
    public void init() {
        AircraftImpl a = new AircraftImpl(1, "A", 200,
                150, 12, 25);
        ArrayList<Aircraft> list = new ArrayList<Aircraft>();
        list.add(a);
        list.add(new AircraftImpl(2, "B", 234,
                345, 12, 56));
        list.add(new AircraftImpl(3, "C", 567,
                543, 67, 67));
        list.add(new PassengerAircraft(4, "D", 4574, 23,
                34, 43, 55));
        airline = new AirlineImpl(list);
    }

    @Test
    public void addAircraftTest() {
        Aircraft aircraft = new AircraftImpl(12,"ABC", 34, 150, 45, 78);
        airline.addAircraft(aircraft);
        assertTrue(airline.getAircraftList().contains(aircraft));
    }

    @Test
    public void addAircraftTest_2() {
        try {
            airline.addAircraft(null);
            fail();
        }catch(Exception e) {

        }
    }

    @Test
    public void getAircraftSortedByFlightRangeTest() {
        ArrayList<Aircraft> testList = (ArrayList<Aircraft>) airline.getAircraftSortedByFlightRange();
        for (int i = 1; i < testList.size(); i++) {
            if (testList.get(i).getFlightRange() < testList.get(i-1).getFlightRange())
                Assert.fail();
        }
    }

    @Test
    public void getAircrafByFuelConsumtionRangeTest() {
        Aircraft t1 = new AircraftImpl(2, "B", 234,
                345, 12, 74);
        Aircraft t2 = new AircraftImpl(2, "B", 234,
                345, 12, 80);
        airline.addAircraft(t1);
        airline.addAircraft(t2);
        List<Aircraft> testList = airline.getAircrafByFuelConsumtionRange(74, 80);
        assertTrue(testList.contains(t1) && testList.contains(t2));
    }

    /**
     * Testing how method throws exception.
     */
    @Test
    public void getAircrafByFuelConsumtionRangeTest_2() {
        try {
            airline.getAircrafByFuelConsumtionRange(-2, 34);
            fail();
        }catch(Exception e) {

        }
    }

    @Test
    public void getAircrafByFuelConsumtionRangeTest_3() {
        try {
            airline.getAircrafByFuelConsumtionRange(35, 34);
            fail();
        }catch(Exception e) {

        }
    }

    @Test
    public void getTotalPassengerCapacityTest() {
        PassengerAircraft a1 = new PassengerAircraft(1,"W", 123,
                333,44,45,55);
        PassengerAircraft a2 = new PassengerAircraft(1,"W", 123,
                333,44,45,145);
        List<Aircraft> list = new ArrayList<Aircraft>();
        list.add(a1);
        list.add(a2);
        Airline airline = new AirlineImpl(list);
        assertTrue(airline.getTotalPassengerCapacity() == a1.getPassengerCapacity() + a2.getPassengerCapacity());
    }

    @Test
    public void getTotalCarryingCapacityTest() {
        PassengerAircraft a1 = new PassengerAircraft(1,"W", 123,
                333,44,45,55);
        PassengerAircraft a2 = new PassengerAircraft(1,"W", 123,
                333,44,45,145);
        List<Aircraft> list = new ArrayList<Aircraft>();
        list.add(a1);
        list.add(a2);
        Airline airline = new AirlineImpl(list);
        assertTrue(airline.getTotalCarryingCapacity() ==
                a1.getCarryingCapacity() + a2.getCarryingCapacity());
    }

    @Test
    public void getTotalAircraftCapacityTest() {
        PassengerAircraft a1 = new PassengerAircraft(1,"W", 123,
                333,44,45,55);
        PassengerAircraft a2 = new PassengerAircraft(1,"W", 123,
                333,44,45,145);
        List<Aircraft> list = new ArrayList<Aircraft>();
        list.add(a1);
        list.add(a2);
        Airline airline = new AirlineImpl(list);
        assertTrue(airline.getTotalAircraftCapacity() ==
                a1.getCapacity() + a2.getCapacity());
    }

}