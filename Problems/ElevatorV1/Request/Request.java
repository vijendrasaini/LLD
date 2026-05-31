package Problems.ElevatorV1.Request;

import Problems.ElevatorV1.FloorButton;
import Problems.ElevatorV1.Elevator;

public abstract class Request {
    private Elevator elevetor;
    public Request(Elevator elevetor) {
        this.elevetor = elevetor;
    }
    public Elevator getElevetor() {
        return elevetor;
    }
    public void setElevetor(Elevator elevetor) {
        this.elevetor = elevetor;
    }
}

class InternalRequest extends Request{
    private FloorButton floorButton;
    public InternalRequest(Elevator elevetor, FloorButton floorButton) {
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