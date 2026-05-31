package Problems.Elevator.Request;
import Problems.Elevator.Direction;
import Problems.Elevator.Floor;
import Problems.Elevator.Lift;

public class ExternalRequest extends Request {
    private Direction direction;
    private Floor userAtFloor;

    public ExternalRequest(Lift elevetor, Direction direction, Floor userAtFloor)
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
