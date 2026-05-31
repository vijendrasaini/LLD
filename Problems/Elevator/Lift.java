package Problems.Elevator;

import java.util.ArrayList;
import java.util.Collection;

import Problems.Elevator.Request.ExternalRequest;

public class Lift {
    private int id;
    private Floor currentFloor;
    private static int nextId = 1;

    private ElevetorState elevetorState;

    private Collection<Floor> pendingUpRequests;
    private Collection<Floor> pendingDownRequest;

    public Lift() {
        this.id = Lift.nextId ++;// Mimicking unique Id behavior using auto increment concept

        currentFloor = Floor.GROUND;
        elevetorState = ElevetorState.IN_REST;
        pendingUpRequests = new ArrayList<>();
        pendingDownRequest = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }
    
    public ElevetorState getElevetorState() {
        return elevetorState;
    }
    
    public void setElevetorState(ElevetorState elevetorState) {
        // Only to be called by Floor Detectors
        this.elevetorState = elevetorState;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
        processPendindgRequests(currentFloor);
    }

    private void processPendindgRequests(Floor forFloor) {
        System.out.println("Processing request for : " + forFloor);
        // Safely remove the current floor from both lists without explicit loops
        int size = pendingDownRequest.size() + pendingUpRequests.size();
        pendingDownRequest.removeIf(floor -> floor == forFloor);
        pendingUpRequests.removeIf(floor -> floor == forFloor);
        int nowSize = pendingDownRequest.size() + pendingUpRequests.size();
        if(size != nowSize) {
            openTheDoor(); // door will be open if some request have been processed.
        }

        // If no requests remain, change the state to REST
        if (pendingDownRequest.isEmpty() && pendingUpRequests.isEmpty()) {
            setElevetorState(ElevetorState.IN_REST);
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
        switch (elevetorState) {
            case MOVEING_DOWN:
                if(currentFloor.ordinal() - floor.ordinal() > 0) {
                    pendingDownRequest.add(floor);
                } else {
                    pendingUpRequests.add(floor);
                }
                break;
            case MOVEING_UP:
                if(floor.ordinal() - currentFloor.ordinal() > 0) {
                    pendingUpRequests.add(floor);
                }
                else {
                    pendingDownRequest.add(floor);
                }
                break;
            default:
                if(currentFloor == floor) {
                    // Lift is there only nothing to be done
                    break;
                }

                if(currentFloor.ordinal() - floor.ordinal() > 0) {
                    pendingDownRequest.add(floor);
                    elevetorState = ElevetorState.MOVEING_DOWN;
                } else {
                    pendingUpRequests.add(floor);
                    elevetorState = ElevetorState.MOVEING_UP;
                }
                break;
        }

        closeTheDoor();

        // show the status of lift if this is called
        printLiftCurrentSituation();
    }    

    // just for visulization
    public void printLiftCurrentSituation() {
        System.out.println();
        System.out.println("ID : " + id);
        System.out.println("Current State : " + elevetorState + ", Current Floor : " + currentFloor);
        System.out.println("Pending Lists : ");
        System.out.println("UP : " + pendingUpRequests);
        System.out.println("DOWN : " + pendingDownRequest);
        System.out.println();
    }

    public void openTheDoor() {
        System.out.println("Lift-%d | Opening the doors...".formatted(id));
    }

    public void closeTheDoor() {
        System.out.println("Lift-%d | Closing the doors...".formatted(id));
    }
}
