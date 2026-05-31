package Problems.ElevatorV1.Request;
import Problems.ElevatorV1.Direction;
import Problems.ElevatorV1.Floor;
import Problems.ElevatorV1.Elevator;

public class ExternalRequest extends Request {
    private Direction direction;
    private Floor userAtFloor;

    public ExternalRequest(Elevator elevetor, Direction direction, Floor userAtFloor)
    {
        super(elevetor);
        this.direction = direction;
        this.userAtFloor = userAtFloor;
    }

    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction Direction) {
        this.direction = Direction;
    }
    public Floor getUserAtFloor() {
        return userAtFloor;
    }    
}
