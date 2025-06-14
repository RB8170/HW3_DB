// === Main.java ===
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            CarDAO carDAO = new CarDAO();
            OwnerDAO ownerDAO = new OwnerDAO();

            while (true) {
                System.out.println("\n1. Add Owner");
                System.out.println("2. Add Car");
                System.out.println("3. View Parked Cars");
                System.out.println("4. Remove Car");
                System.out.println("0. Exit");
                int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter phone: ");
                        String phone = sc.nextLine();
                        int id = ownerDAO.addOwner(new Owner(name, phone));
                        System.out.println("Owner added with ID: " + id);
                    }
                    case 2 -> {
                        System.out.print("Enter license plate: ");
                        String plate = sc.nextLine();
                        System.out.print("Enter model: ");
                        String model = sc.nextLine();
                        System.out.print("Enter color: ");
                        String color = sc.nextLine();
                        System.out.print("Enter owner ID: ");
                        int ownerId = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter worker code: ");
                        String workerCode = sc.nextLine();
                        carDAO.addCar(new Car(plate, model, color, true, ownerId, workerCode));
                        System.out.println("Car added to parking lot.");
                    }
                    case 3 -> {
                        List<String> cars = carDAO.getAllParkedCars();
                        System.out.println("\nParked Cars:");
                        cars.forEach(System.out::println);
                    }
                    case 4 -> {
                        System.out.print("Enter license plate to remove: ");
                        String plate = sc.nextLine();
                        carDAO.removeCar(plate);
                        System.out.println("Car removed from parking lot.");
                    }
                    case 0 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
