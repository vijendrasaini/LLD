package model;

import enums.ParkingSpotStatus;
import enums.ParkingSpotType;

public class ParkingSpot {
    private int spotId;
    private ParkingSpotType spotType;
    private ParkingSpotStatus status;

    public ParkingSpot(int spotId, ParkingSpotType pst) {
        this.spotId = spotId;
        this.spotType = pst;
        this.status = ParkingSpotStatus.Free;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(ParkingSpotType spotType) {
        this.spotType = spotType;
    }

    public boolean isFree() {
        return status == ParkingSpotStatus.Free;
    }

    public synchronized void book() {
        if(status == ParkingSpotStatus.Reserved) {
            throw new RuntimeException("Not available");
        }

        this.status = ParkingSpotStatus.Reserved;
    }

    public synchronized boolean tryBook() {
        if(status == ParkingSpotStatus.Free) {
            this.status = ParkingSpotStatus.Reserved;
            return true;
        }

        return false;
    }

    public synchronized void makeAvailable() {
        this.status = ParkingSpotStatus.Free;
    }
}
