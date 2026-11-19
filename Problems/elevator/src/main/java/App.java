import enums.Direction;
import enums.Floor;
import model.ElevatorCar;
import service.ElevatorSystem;
import strategy.ElevatorSelectionStrategy;
import strategy.NearestElevatorStrategy;

public class App {
    static void main(String[] args) {
        build();
    }

    static void build() {
        ElevatorCar ec1 = new ElevatorCar(1);
        ElevatorCar ec2 = new ElevatorCar(2);

        ElevatorSelectionStrategy strategy = new NearestElevatorStrategy();
        ElevatorSystem controller = new ElevatorSystem(strategy);
        controller.addElevatorCar(ec1);
        controller.addElevatorCar(ec2);

        controller.showStatus();
        controller.requestFloor(Floor.FIFTH_FLOOR, ec1, Direction.UP);
        controller.requestFloor(Floor.FIFTH_FLOOR, ec2, Direction.DOWN);
        controller.step();
        controller.step();
        controller.requestFloor(Floor.GROUND_FLOOR, ec1, Direction.UP);
        controller.requestFloor(Floor.SEVENTH_FLOOR, ec2, Direction.DOWN);

        controller.showStatus();
        controller.step();
        controller.step();
        controller.step();
        controller.step();
        controller.step();
        controller.step();
        controller.step();
        controller.step();
        controller.pressFloorButton(Floor.FOURTH_FLOOR, ec1);
        controller.showStatus();
        controller.step();
        controller.step();
        controller.step();
        controller.step();
    }
}
