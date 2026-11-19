package model;

import enums.Floor;

public class Request {
    private Floor destination;
    private ElevatorCar requestFromElevator;

    public Request(Floor floor, ElevatorCar elevatorCar) {
        this.destination = floor;
        this.requestFromElevator = elevatorCar;
    }

    public Floor getDestination() {
        return destination;
    }

    public ElevatorCar getRequestFromElevator() {
        return requestFromElevator;
    }
}
