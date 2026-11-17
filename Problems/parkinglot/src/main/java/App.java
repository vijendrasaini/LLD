import enums.ParkingSpotType;
import factory.CarVehicleFactory;
import factory.VehicleFactory;
import model.Floor;
import model.ParkingSpot;
import model.ParkingTicket;
import model.Vehicle;
import strategy.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ParkingLot parkingLot = buildParkingLot();

        VehicleFactory carFactory = new CarVehicleFactory();
        Vehicle car1 = carFactory.createVehicle("RJ18XA1234");

        ParkingTicket ticket1 = parkingLot.parkVehicle(car1);
        System.out.println(ticket1);

        // after quite some time
        ParkingTicket ticket2 = parkingLot.unparkVehicle(ticket1);
        System.out.println(ticket1);
    }

    public static ParkingLot buildParkingLot() {
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);

        ParkingSpot parkingSpot1 = new ParkingSpot(1, ParkingSpotType.MOTORCYCLE_SPOT);
        ParkingSpot parkingSpot2 = new ParkingSpot(2, ParkingSpotType.COMPACT_SPOT);
        ParkingSpot parkingSpot3 = new ParkingSpot(3, ParkingSpotType.LARGE_SPOT);

        ParkingSpot parkingSpot11 = new ParkingSpot(11, ParkingSpotType.MOTORCYCLE_SPOT);
        ParkingSpot parkingSpot12 = new ParkingSpot(12, ParkingSpotType.COMPACT_SPOT);
        ParkingSpot parkingSpot13 = new ParkingSpot(13, ParkingSpotType.LARGE_SPOT);

        floor1.addSpot(parkingSpot1);
        floor1.addSpot(parkingSpot2);
        floor1.addSpot(parkingSpot3);

        floor2.addSpot(parkingSpot11);
        floor2.addSpot(parkingSpot12);
        floor2.addSpot(parkingSpot13);

        List<Floor> floorList = new ArrayList<>();
        floorList.add(floor1);
        floorList.add(floor2);

        SpotAssignmentStrategy spotAssignmentStrategy = new VehicleTypeSpotAssignmentStrategy(floorList);
        PaymentCalculationStrategy paymentCalculationStrategy = new TimeBasedPaymentCalculationStrategy();
        return new ParkingLot(floorList, spotAssignmentStrategy, paymentCalculationStrategy);
    }
}
