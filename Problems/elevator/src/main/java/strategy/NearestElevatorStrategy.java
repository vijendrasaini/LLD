package strategy;

import model.ElevatorCar;
import model.Request;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{
    @Override
    public ElevatorCar getElevator(List<ElevatorCar> elevatorCarList, Request request) {
        ElevatorCar selectedElevator = elevatorCarList.getFirst();
        int nearestGap = Integer.MAX_VALUE;
        for(ElevatorCar elevatorCar: elevatorCarList) {
            int f = request.getDestination().ordinal();
            int ef = elevatorCar.getCurrentFloor().ordinal();

            if(nearestGap > Math.abs(f - ef)) {
                selectedElevator = elevatorCar;
                nearestGap = Math.abs(f - ef);
            }
        }

        return selectedElevator;
    }
}
