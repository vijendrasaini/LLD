package model;

import enums.ParkingSportStatus;
import enums.ParkingSpotType;

public class ParkingSpot {
    private int spotId;
    private ParkingSpotType spotType;
    private ParkingSportStatus status;

    public ParkingSpot(int spotId, ParkingSpotType pst) {
        this.spotId = spotId;
        this.spotType = pst;
        this.status = ParkingSportStatus.Free;
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
        return status == ParkingSportStatus.Free;
    }

    public synchronized void book() {
        if(status == ParkingSportStatus.Reserved) {
            throw new RuntimeException("Not available");
        }

        this.status = ParkingSportStatus.Reserved;
    }

    public void makeAvailable() {
        this.status = ParkingSportStatus.Free;
    }
}
