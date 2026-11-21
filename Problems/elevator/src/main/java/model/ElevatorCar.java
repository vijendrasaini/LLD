package model;

import config.FloorConfig;
import enums.Direction;
import enums.ElevatorState;
import enums.Floor;

import java.util.Set;
import java.util.TreeSet;

public class ElevatorCar {
    Direction direction;
    int id;
    Floor currentFloor;
    ElevatorState state;

    Set<Floor> upStops = new TreeSet<>((a, b) -> b.ordinal() - a.ordinal());
    Set<Floor> downStops = new TreeSet<>((a, b) -> a.ordinal() - b.ordinal());

    public ElevatorCar(int id) {
        this.id = id;
        direction = Direction.UP;
        state = ElevatorState.IDLE;
        currentFloor = Floor.GROUND_FLOOR;
    }

    void moves() {

    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void openTheDoor() {
        System.out.println("Opening the door....");
    }

    public void closeTheDoor() {
        System.out.println("Closing the door....");
    }

    public int getId() {
        return id;
    }

    public void showStatus(int atTime) {
        System.out.printf("--------------Elevator: %s-------------------%n", id);
        System.out.printf("At Time: %s, Current Floor: %s, State: %s, direction: %s, Up request: %s, Down Request: %s\n", atTime, currentFloor, state, direction, upStops, downStops);
    }

    public synchronized void addStop(Floor floor) {
        int current = this.currentFloor.ordinal();
        int target = floor.ordinal();

        if(target < current) {
            this.downStops.add(floor);
            if(state == ElevatorState.IDLE) {
                direction = Direction.DOWN;
            }

            return;
        }

        if(target > current) {
            this.upStops.add(floor);
            if(state == ElevatorState.IDLE) {
                direction = Direction.UP;
            }

            return;
        }

        openTheDoor();
    }

    public synchronized void step() {
        if(state == ElevatorState.IDLE) {
            if(upStops.isEmpty() && downStops.isEmpty()) {
                System.out.printf("EC : %d is IDLE%n", id);
                return;
            }
        }

        state = ElevatorState.MOVING;
        if(direction == Direction.UP) {
            processUpwardFloor();
        } else {
            processDownwardFloor();
        }
    }

    private void processUpwardFloor() {
        currentFloor = FloorConfig.next(currentFloor);
        if(upStops.remove(currentFloor)) {
            openTheDoor();
            if(upStops.isEmpty()) {
                if(downStops.isEmpty()) {
                    state = ElevatorState.IDLE;
                } else {
                    direction = Direction.DOWN;
                }
            }
        }

        if(currentFloor == FloorConfig.getTopFloor()) direction = Direction.DOWN;
    }

    private void processDownwardFloor() {
        currentFloor = FloorConfig.prev(currentFloor);
        if(downStops.remove(currentFloor)) {
            openTheDoor();
            if(downStops.isEmpty()) {
                if(upStops.isEmpty()) {
                    state = ElevatorState.IDLE;
                } else {
                    direction = Direction.UP;
                }
            }
        }

        if(currentFloor == FloorConfig.getGroundFloor()) direction = Direction.UP;
    }
}
