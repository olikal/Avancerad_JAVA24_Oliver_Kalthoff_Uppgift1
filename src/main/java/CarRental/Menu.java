package CarRental;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Menu {
    private HashMap<String, Object> vehicleList = new LinkedHashMap<>();

    public void skapaFordon() {
        vehicleList.put("ASD123",
                new Car("ASD123", "BMW", "X5", 1250, "Black", 5));
        vehicleList.put("ASD456",
                new Car ("ASD456", "Volvo", "XC60", 1000, "White", 5));
        vehicleList.put("ASD789",
                new Car ("ASD789", "Toyota", "Supra", 750, "Red", 5));
        vehicleList.put("QWE123",
                new Motorcycle ("QWE123", "Harley Davidson", "Street Glide", 900, "Black", 2));
        vehicleList.put("QWE456",
                new Motorcycle ("QWE456", "Kawasaki", "Ninja", 700, "Black", 2));
        vehicleList.put("QWE789",
                new Motorcycle ("QWE789", "Yamaha", "Niken", 800, "Black", 3));
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        skapaFordon();

        while (true){
            System.out.println("Welcome to CarRental!\n");
            System.out.println("1. See list of vehicles");
            System.out.println("2. Rent car");
            System.out.println("3. Return car");
            System.out.println("4. Exit\n");
            System.out.println("Please make a choice using the numbers above");


            int menuChoice = scanner.nextInt();
            scanner.nextLine();


            switch (menuChoice) {
                case 1:
                    for (Object vehicle : vehicleList.values()){
                        System.out.println(vehicle);
                    }
                    break;
                case 2:
                    System.out.println("Enter registration ID for the vehicle you want to rent");
                    String selectedVehicle = scanner.nextLine().toUpperCase();
                    if (vehicleList.containsKey(selectedVehicle)) {
                        Vehicle vehicle = (Vehicle) vehicleList.get(selectedVehicle);
                        vehicle.rentVehicle();
                        vehicleList.remove(selectedVehicle);
                    } else {
                        System.out.println("Vehicle not found");
                    }
                    break;
                case 3:
                    // ToDo - implement return feature
                    break;
                case 4:
                    System.out.println("Please come again!");
                    return;
                default:
                    System.out.println("Please enter a valid option, numbers 1-4.");
            }

        }

    }


}
