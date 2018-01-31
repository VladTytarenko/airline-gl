package com.tytarenko.operation;

/*
 * $today.date
 */
public enum OperationEnum {

    FLIGHT_RANGE(1),
    PASSENGER_CAPACITY(2),
    CAPACITY(3),
    CARRYING_CAPACITY(4),
    FUEL_CONSUMTION(5),
    ADD(6),
    REMOVE(7),
    EXIT(0);

    int operationNum;

    OperationEnum(int operationNum) {
        this.operationNum = operationNum;
    }

    public int getOperationNum() {
        return operationNum;
    }

}
