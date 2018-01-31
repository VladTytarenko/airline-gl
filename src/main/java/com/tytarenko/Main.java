package com.tytarenko;

import com.tytarenko.aircraft.Aircraft;
import com.tytarenko.aircraft.AircraftImpl;
import com.tytarenko.aircraft.PassengerAircraft;
import com.tytarenko.airline.AirlineImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.tytarenko.operation.OperationEnum.*;

/**
 * @author Vladyslav Tytarenko
 * Main class with start method.
 */

public class Main {

    private static AirlineImpl airline;
    private static Scanner scn;

    private static void controller(int operationNum) {
        boolean fuelCon, addCon;
        if (operationNum == FLIGHT_RANGE.getOperationNum())
            System.out.println("Aircrafts sorted by flight range: " + airline.getAircraftSortedByFlightRange() + "\n");

        else if (operationNum == PASSENGER_CAPACITY.getOperationNum())
            System.out.println("Total passenger capacity: " + airline.getTotalPassengerCapacity());

        else if (operationNum == CAPACITY.getOperationNum())
            System.out.println("Total capacity:" + airline.getTotalAircraftCapacity());

        else if (operationNum == CARRYING_CAPACITY.getOperationNum())
            System.out.println("Total carrying capacity: " + airline.getTotalCarryingCapacity());

        else if (operationNum == FUEL_CONSUMTION.getOperationNum()) {

            fuelCon = false;
            while (!fuelCon) {
                try {
                    System.out.println("Enter minimal fuel consumption: ");
                    String str = scn.next();
                    int f1 = Integer.parseInt(str);
                    System.out.println("Enter maximal fuel consumption:");
                    str = scn.next();
                    int f2 = Integer.parseInt(str);
                    List<Aircraft> aircrafts = airline.getAircrafByFuelConsumtionRange(f1, f2);
                    if (aircrafts.size() > 0)
                        System.out.println(aircrafts);
                    else
                        System.out.println("Airplanes that satisfy the conditions were not found\n");
                    fuelCon = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Only numbers available\nPlease, enter correct values(min <= max and min >= 0)\n");
                } catch (Exception e) {
                    System.out.println("Only numbers available\n");
                }
            }
        }
        else if (operationNum == ADD.getOperationNum()) {
            addCon = false;
            while (!addCon) {
                try {
                    System.out.println("Enter values");
                    System.out.println("Serial Number: ");
                    String str = scn.next();
                    long id = Long.parseLong(str);
                    System.out.println("Model:");
                    String model = scn.next();
                    System.out.println("Flight range: ");
                    str = scn.next();
                    double flightRange = Double.parseDouble(str);
                    System.out.println("Capacity: ");
                    double capacity = Double.parseDouble(scn.next());
                    System.out.println("Carrying capacity: ");
                    double carryingCapacity = Double.parseDouble(scn.next());
                    System.out.println("Fuel consumption: ");
                    double fuelConsumption = Double.parseDouble(scn.next());
                    airline.addAircraft(new AircraftImpl(id, model, flightRange, capacity, carryingCapacity, fuelConsumption));
                    addCon = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Enter correct values");
                } catch (Exception e) {
                    System.out.println("Only numbers avalible");
                }
            }

        }
        else if (operationNum == REMOVE.getOperationNum()) {
            System.out.println(REMOVE);
            for (int i = 0; i < airline.getAircraftList().size(); i ++)
                System.out.println("id: " + i + airline.getAircraftList().get(i) + "\n");
            System.out.println("\nEnter id of aircraft: ");
            try {
                airline.removeAicraft(scn.nextInt());
            } catch (Exception e) {
                System.out.println("Try again!!!");
            }
        }
        else
            System.out.println("Number of command should be from 0 to 7.\n");
    }

    /**
     * Start method.
     */
    public static void main(String[] args) {
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

        scn = new Scanner(System.in);

        int operationNum = 10;
        while (operationNum != EXIT.getOperationNum()) {
            System.out.println(FLIGHT_RANGE.getOperationNum() + " - display the list of aircraft of " +
                        "the company sorted by flight range.");
            System.out.println(PASSENGER_CAPACITY.getOperationNum() + " - display total passanger capacity");
            System.out.println(CAPACITY.getOperationNum() + " - display total capacity");
            System.out.println(CARRYING_CAPACITY.getOperationNum() + " - dispaly total carrying capacity");
            System.out.println(FUEL_CONSUMTION.getOperationNum() + " - airplanes corresponding to a given " +
                        "range of fuel consumption parameters");
            System.out.println(ADD.getOperationNum() + " - add new aircraft");
            System.out.println(REMOVE.getOperationNum() + " - remove aircraft by id");
            System.out.println(EXIT.getOperationNum() + " - exit");
            System.out.println("Select command: ");

            try {
                String str = scn.nextLine();
                operationNum = Integer.parseInt(str);
                controller(operationNum);

            } catch (Exception e) {
                System.out.println("Please, enter correct values\n");
            }
        }

    }
}

