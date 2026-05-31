package Problems.ElevatorV1;

import java.util.ArrayList;
import java.util.Collection;

import Problems.ElevatorV1.Request.ExternalRequest;

public class Elevator {
    private int id;
    private Floor currentFloor;
    private static int nextId = 1;

    private ElevatorState elevatorState;

    private Collection<Floor> pendingUpRequests;
    private Collection<Floor> pendingDownRequests;

    public Elevator() {
        this.id = Elevator.nextId ++;// Mimicking unique Id behavior using auto increment concept

        currentFloor = Floor.GROUND;
        elevatorState = ElevatorState.IN_REST;
        pendingUpRequests = new ArrayList<>();
        pendingDownRequests = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }
    
    public ElevatorState getElevatorState() {
        return elevatorState;
    }
    
    public void setElevatorState(ElevatorState elevatorState) {
        // Only to be called by Floor Detectors
        this.elevatorState = elevatorState;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
        processPendindgRequests(currentFloor);
    }

    private void processPendindgRequests(Floor forFloor) {
        System.out.println("Processing request for : " + forFloor);
        // Safely remove the current floor from both lists without explicit loops
        int size = pendingDownRequests.size() + pendingUpRequests.size();
        pendingDownRequests.removeIf(floor -> floor == forFloor);
        pendingUpRequests.removeIf(floor -> floor == forFloor);
        int nowSize = pendingDownRequests.size() + pendingUpRequests.size();
        if(size != nowSize) {
            openTheDoor(); // door will be open if some request have been processed.
        }

        // If no requests remain, change the state to REST
        if (pendingDownRequests.isEmpty() && pendingUpRequests.isEmpty()) {
            setElevatorState(ElevatorState.IN_REST);
        }

        printLiftCurrentSituation();
    }

    public void processExternalRequest(Direction direction, Floor userAtFloor) {
        if(currentFloor == userAtFloor) {
            System.out.println("User is at same floor where lift currently is.");
            openTheDoor();
            return;
        }

        Controller.getInstance().processExternalRequest(new ExternalRequest(this, direction, userAtFloor));
        // show the status of lift if this is called
        printLiftCurrentSituation();
    }

    public void processDestinationFloor(Floor floor) {
        submitRequest(floor);
    }    

    public void submitRequest(Floor destinationFloor) {

        if (isAlreadyAtDestination(destinationFloor)) {
            return;
        }

        addRequest(destinationFloor);

        updateStateIfIdle(destinationFloor);

        closeTheDoor();

        // // show the status of lift if this is called
        printLiftCurrentSituation();
    }

    private boolean isAlreadyAtDestination(Floor destinationFloor) {
        return currentFloor == destinationFloor;
    }

    private void addRequest(Floor destinationFloor) {

        switch (elevatorState) {

            case MOVEING_UP ->
                    handleWhileMovingUp(destinationFloor);

            case MOVEING_DOWN ->
                    handleWhileMovingDown(destinationFloor);

            case IN_REST ->
                    handleWhileIdle(destinationFloor);
        }
    }

    private void handleWhileMovingUp(Floor destinationFloor) {

        if (destinationFloor.ordinal() > currentFloor.ordinal()) {
            pendingUpRequests.add(destinationFloor);
        } else {
            pendingDownRequests.add(destinationFloor);
        }
    }

    private void handleWhileMovingDown(Floor destinationFloor) {

        if (destinationFloor.ordinal() < currentFloor.ordinal()) {
            pendingDownRequests.add(destinationFloor);
        } else {
            pendingUpRequests.add(destinationFloor);
        }
    }

    private void handleWhileIdle(Floor destinationFloor) {

        if (destinationFloor.ordinal() > currentFloor.ordinal()) {

            pendingUpRequests.add(destinationFloor);

        } else {

            pendingDownRequests.add(destinationFloor);
        }
    }

    private void updateStateIfIdle(Floor destinationFloor) {

        if (elevatorState != ElevatorState.IN_REST) {
            return;
        }

        if (destinationFloor.ordinal() > currentFloor.ordinal()) {
            elevatorState = ElevatorState.MOVEING_UP;
        } else {
            elevatorState = ElevatorState.MOVEING_DOWN;
        }
    }

    // just for visulization
    public void printLiftCurrentSituation() {
        System.out.println();
        System.out.println("ID : " + id);
        System.out.println("Current State : " + elevatorState + ", Current Floor : " + currentFloor);
        System.out.println("Pending Lists : ");
        System.out.println("UP : " + pendingUpRequests);
        System.out.println("DOWN : " + pendingDownRequests);
        System.out.println();
    }

    public void openTheDoor() {
        System.out.println("Lift-%d | Opening the doors...".formatted(id));
    }

    public void closeTheDoor() {
        System.out.println("Lift-%d | Closing the doors...".formatted(id));
    }
}
