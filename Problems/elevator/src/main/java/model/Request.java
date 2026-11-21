package model;

import enums.Floor;

public class Request {
    private final Floor destination;

    public Request(Floor floor) {
        this.destination = floor;
    }

    public Floor getDestination() {
        return destination;
    }
}
