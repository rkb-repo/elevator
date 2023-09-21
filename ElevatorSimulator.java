import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Elevator {
    private int currentFloor;
    private Queue<Integer> requests;
    private Map<Integer, String> floorNames;

    public Elevator() {
        currentFloor = 0; //Ground Floor
        requests = new LinkedList<>();

        //Naming the floors.
        floorNames = new HashMap<>();
        floorNames.put(0, "Ground Floor");
        floorNames.put(1, "1st Floor");
        floorNames.put(2, "2nd Floor");
        floorNames.put(3, "3rd Floor");
        for (int i = 4; i <= 10; i++) {
            floorNames.put(i, i + "th Floor");
        }
    }

    public void requestFloor(int floor) {
        if (floor >= 0 && floor <= 10) {
            System.out.println("Elevator received a request for " + floorNames.get(floor));
            requests.offer(floor);
        } else {
            System.out.println("Invalid floor number.");
        }
    }

    public void move() {
        while (!requests.isEmpty()) {
            int nextFloor = requests.poll();
            System.out.println("Elevator moving from " + floorNames.get(currentFloor) + " to " + floorNames.get(nextFloor));
            currentFloor = nextFloor;
            System.out.println("Elevator has arrived at " + floorNames.get(currentFloor));
        }
    }

    public String getCurrentFloorName() {
        return floorNames.get(currentFloor);
    }
}

public class ElevatorSimulator {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Current Floor: " + elevator.getCurrentFloorName());
            System.out.print("Enter a floor number (0-10) or 'X' to exit: ");
            String input = scanner.next().trim();
            
            //Using uppercase X as exit function because it looks cooler than a random out of bounds number.
            if (input.equalsIgnoreCase("X")) {
                System.out.println("Exiting the elevator. Have a happy day!");
                break;
            }

            try {
                int floor = Integer.parseInt(input);
                elevator.requestFloor(floor);
                elevator.move();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a floor number (0-10) or 'X' to exit.");
            }
        }

        scanner.close();
    }
}
