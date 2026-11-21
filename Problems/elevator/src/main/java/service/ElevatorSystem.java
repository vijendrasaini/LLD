package service;

import enums.Direction;
import enums.ElevatorState;
import enums.Floor;
import model.ElevatorCar;
import model.Request;
import strategy.ElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    List<ElevatorCar> elevatorCars;
    ElevatorSelectionStrategy selectionStrategy;
    private static int timer = 0;
    public ElevatorSystem(ElevatorSelectionStrategy strategy) {
        this.selectionStrategy = strategy;
        this.elevatorCars = new ArrayList<>();
    }

    public void addElevatorCar(ElevatorCar ec) {
        this.elevatorCars.add(ec);
    }

    public void requestFloor(Floor floor, Direction direction) {
        System.out.printf("Request for Floor: %s to go: %s", floor, direction);
        Request request = new Request(floor, direction);
        ElevatorCar selectedElevator = selectionStrategy.getElevator(elevatorCars, request);

        int carFloor = selectedElevator.getCurrentFloor().ordinal();
        int destFloor = floor.ordinal();

/*        if(elevatorCar.getState() == ElevatorState.IDLE) {
            if(destFloor < carFloor) {
                selectedElevator.setDirection(Direction.DOWN);
            } else if(destFloor > carFloor) {
                selectedElevator.setDirection(Direction.UP);
            } else {
                // on the same floor;
                selectedElevator.openTheDoor();
            }
        }*/

        selectedElevator.addStop(floor);
    }

    public void pressFloorButton(Floor destFloor, ElevatorCar elevatorCar) {
        if(elevatorCar.getCurrentFloor() == destFloor) {
            elevatorCar.openTheDoor();
            return;
        }

        elevatorCar.addStop(destFloor);
    }

    public void step() {
        timer++;
        for(ElevatorCar ec: elevatorCars) ec.step();
        showStatus();
    }

    public void showStatus() {
        for(ElevatorCar ec: elevatorCars) ec.showStatus(timer);
    }
}
