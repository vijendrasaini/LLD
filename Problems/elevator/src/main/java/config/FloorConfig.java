package config;

import enums.Floor;

public class FloorConfig {
    private static final Floor[] floors = Floor.values();

    public static Floor getGroundFloor() {
        return floors[0];
    }

    public static Floor getTopFloor() {
        return floors[floors.length - 1];
    }

    public static Floor next(Floor floor) {
        if(floor == getTopFloor()) {
            if(floors.length == 1) return floors[floors.length - 1];

            return floors[floors.length - 2];
        }

        return floors[floor.ordinal() + 1];
    }


    public static Floor prev(Floor floor) {
        if(floor == getGroundFloor()) {
            if(floors.length == 1) return floors[floors.length - 1];

            return floors[1];
        }

        return floors[floor.ordinal() - 1];
    }
}
