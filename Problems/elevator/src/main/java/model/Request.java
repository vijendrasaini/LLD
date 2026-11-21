package model;

import enums.Direction;
import enums.Floor;

public class Request {
    private final Floor destination;
    private Direction direction;

    public Request(Floor floor, Direction direction) {
        this.destination = floor;
        this.direction = direction;
    }

    public Floor getDestination() {
        return destination;
    }

    public Direction getDirection() {
        return direction;
    }


}
