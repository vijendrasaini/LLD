package Problems.Elevator.Request;

import Problems.Elevator.FloorButton;
import Problems.Elevator.Lift;

public abstract class Request {
    private Lift elevetor;
    public Request(Lift elevetor) {
        this.elevetor = elevetor;
    }
    public Lift getElevetor() {
        return elevetor;
    }
    public void setElevetor(Lift elevetor) {
        this.elevetor = elevetor;
    }
}

class InternalRequest extends Request{
    private FloorButton floorButton;
    public InternalRequest(Lift elevetor, FloorButton floorButton) {
        super(elevetor);
        this.floorButton = floorButton;
    }

    public FloorButton getFloorButton() {
        return floorButton;
    }
    public void setFloorButton(FloorButton floorButton) {
        this.floorButton = floorButton;
    }
    
}