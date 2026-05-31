package Problems.ElevatorV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    private static Scanner scanner = new Scanner(System.in);
    private static Lift lift;
    public static void userInputProcessor() {
        try {
            while (true) {
                lift = selectLift();
                System.out.println("Enter 1 : for ExternalRequest");
                System.out.println("Enter 2 : when inside lift");
                System.out.println("Enter 3 : Called by Floor Detection mechanism. ( For now mimicking it )");

                int input = scanner.nextInt();

                switch (input) {
                    case 1:
                        processExternalRequest();
                        break;
                    case 2:
                        processInternalRequest();
                        break;
                    case 3:
                        processFloorDetection();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } catch (java.util.NoSuchElementException e) {
            // This catches the sudden stream closure from Ctrl + C perfectly
            System.out.println("\n[INFO] Application terminated via Ctrl+C. Safe shutdown complete.");
        }
    }

    public static void processExternalRequest() {
        System.out.println("1 : FOR UP");
        System.out.println("2 : FOR DONW");

        int input = scanner.nextInt();
        System.out.println("At which floor, user is ? : ( 0, 1, 2, 3, 4, 5 )");
        
        int floorInput = scanner.nextInt();
        //assuming that input is validated
        Floor floor = Floor.values()[floorInput];
        if(input == 1) {
            lift.processExternalRequest(Direction.UP, floor);
            return;
        }

        lift.processExternalRequest(Direction.DOWN, floor);
    }

    public static void processInternalRequest() {
        System.out.println("Enter Floor ( 0, 1, 2, 3, 4, 5 )");
        
        int input = scanner.nextInt();
        //assuming that input is validated
        Floor floor = Floor.values()[input];
        lift.processDestinationFloor(floor);
    }

    public static Lift selectLift() {
        System.out.println("Select Lift : ");
        System.out.println("ID ( 1 / 2 ) ");
        int id = scanner.nextInt();
        Lift lift = Controller.getInstance().getElevator(id);
        lift.printLiftCurrentSituation();
        return lift;
    }

    public static void processFloorDetection() {
        //assuming that input is validated
        Floor topFloor = Floor.values()[Floor.values().length - 1];
        lift.printLiftCurrentSituation();
        
        if(lift.getElevetorState() != ElevetorState.IN_REST) {
            if(lift.getElevetorState() == ElevetorState.MOVEING_UP) {
                if(lift.getCurrentFloor() == topFloor) {
                    lift.setElevetorState(ElevetorState.MOVEING_DOWN);
                    return;
                }

                System.out.println("Updated FROM " + lift.getCurrentFloor() + " -> " + Floor.values()[lift.getCurrentFloor().ordinal() + 1]);
                lift.setCurrentFloor(Floor.values()[lift.getCurrentFloor().ordinal() + 1]);
                return;
            } else if(lift.getElevetorState() == ElevetorState.MOVEING_DOWN) {
                if(lift.getCurrentFloor() == Floor.GROUND) {
                    lift.setElevetorState(ElevetorState.MOVEING_UP);
                    return;
                }

                System.out.println("Updated FROM " + lift.getCurrentFloor() + " -> " + Floor.values()[lift.getCurrentFloor().ordinal() - 1]);
                lift.setCurrentFloor(Floor.values()[lift.getCurrentFloor().ordinal() - 1]);
                return;
            }
        }

        System.out.println("Can't be called since Lift status is : " + ElevetorState.IN_REST);
        return;
    }
}
