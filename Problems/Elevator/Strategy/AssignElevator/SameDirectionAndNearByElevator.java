package Problems.Elevator.Strategy.AssignElevator;

import java.util.ArrayList;
import java.util.List;

import Problems.Elevator.Direction;
import Problems.Elevator.ElevetorState;
import Problems.Elevator.Floor;
import Problems.Elevator.Lift;
import Problems.Elevator.Strategy.AssignElevetorStrategy;

public class SameDirectionAndNearByElevator implements AssignElevetorStrategy{
    public Lift getElevetor(Lift requestFromLift, List<Lift> lifts, Direction direction) {
        List<Lift> goingInDirectionLifts = new ArrayList<>();
        List<Lift> inRestLifts = new ArrayList<>();
        Floor currentFloor = requestFromLift.getCurrentFloor();

        for (Lift lift : lifts) {
            if(lift.getElevetorState() == ElevetorState.IN_REST) {
                inRestLifts.add(lift);
                continue;
            }

            if(direction == Direction.UP && lift.getElevetorState() == ElevetorState.MOVEING_UP) {
                goingInDirectionLifts.add(lift);
            }
            
            if(direction == Direction.DOWN && lift.getElevetorState() == ElevetorState.MOVEING_DOWN) {
                goingInDirectionLifts.add(lift);
            }
        }

        List<Lift> nearByLifts = new ArrayList<>();
        for (Lift lift : goingInDirectionLifts) {
            if(direction == Direction.UP && currentFloor.ordinal() - lift.getCurrentFloor().ordinal() > 0) { // Potential nearby lift
                nearByLifts.add(lift);
            }

            if(direction == Direction.DOWN && lift.getCurrentFloor().ordinal() - currentFloor.ordinal() > 0) { // Potential nearby lift
                nearByLifts.add(lift);
            }
        }

        if(!nearByLifts.isEmpty()) {
            // sort the list to get near by and return one
            nearByLifts.sort((a, b) -> {
                int result = a.getCurrentFloor().ordinal() - b.getCurrentFloor().ordinal();
                if(direction == Direction.UP) return result;
                return - result;
            });

            return nearByLifts.getLast();
        } else {
            // No potential lift which is move in direction & could be assign in current round 
            // look for InRest and return any one ( However we should check the near by one by the differect with respect to current floor)
            // since some lifts could be above the requested floor or could down to that.
            // for simplicity , returning first from inrest lifts
            if(!inRestLifts.isEmpty()) return inRestLifts.getFirst();
        }

        // if still not found than we have to return lift which is moving in opposite direction and can come quickly
        // for simplicity , return first from the elevetor list since logic will become complex
        return lifts.getFirst();
    }
    
}
