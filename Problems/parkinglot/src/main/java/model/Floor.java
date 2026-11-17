package model;

import enums.ParkingSpotType;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int floorId;
    List<ParkingSpot> spotList;
    public Floor(int floorId) {
        this.floorId = floorId;
        this.spotList = new ArrayList<>();
    }

    public void addSpot(ParkingSpot ps) {
        this.spotList.add(ps);
    }

    public ParkingSpot getAvailableSpot(ParkingSpotType parkingSpotType) {
        for(ParkingSpot spot: spotList) {
            if(spot.getSpotType() == parkingSpotType && spot.tryBook()) {
                return spot;
            }
        }

        return null;
    }
}
