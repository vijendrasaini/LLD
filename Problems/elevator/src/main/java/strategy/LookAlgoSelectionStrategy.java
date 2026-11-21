package strategy;

import config.FloorConfig;
import enums.Direction;
import enums.ElevatorState;
import enums.Floor;
import model.ElevatorCar;
import model.Request;

import java.util.List;

public class LookAlgoSelectionStrategy implements ElevatorSelectionStrategy {
    private final int TOTAL_HEIGHT = FloorConfig.getHeight();

    @Override
    public ElevatorCar getElevator(List<ElevatorCar> elevatorCarList, Request request) {
        ElevatorCar selected = elevatorCarList.getFirst();
        int penality = Integer.MAX_VALUE;

        for(ElevatorCar ec: elevatorCarList) {
            int carPenality = getPenality(ec, request.getDestination(), request.getDirection());
            if(penality > carPenality) {
                selected = ec;
                penality = carPenality;
            }
        }

        return selected;
    }

    public int getPenality(ElevatorCar car, Floor requestedFloor, Direction direction) {
        int current = car.getCurrentFloor().ordinal();
        int target = requestedFloor.ordinal();

        if(car.getState() == ElevatorState.IDLE) {
            // takes some extra time
            int IDLE_DISPATCH_PENALITY = 1;
            return Math.abs(current - target) + IDLE_DISPATCH_PENALITY;
        }

        if(car.getDirection() == Direction.UP && target > current ||
                car.getDirection() == Direction.DOWN && current > target) { // same direction
            return Math.abs(target - current);
        }

        if(car.getDirection() == Direction.UP) {
            return ( TOTAL_HEIGHT - current ) + ( TOTAL_HEIGHT - target ); // Opposite Direction
        }

        return current + target;
    }
}
