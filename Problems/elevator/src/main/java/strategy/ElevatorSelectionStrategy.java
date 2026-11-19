package strategy;

import model.ElevatorCar;
import model.Request;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorCar getElevator(List<ElevatorCar> elevatorCarList, Request request);
}
