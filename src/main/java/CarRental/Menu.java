package CarRental;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Menu {
    private HashMap<String, Vehicle> vehicleList = new LinkedHashMap<>();
    private HashMap<String, Vehicle> rentedVehicleList = new LinkedHashMap<>();

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

        System.out.println("--**|| Welcome to CarRental! ||**--\n");

        while (true){
            System.out.println("1. See list of available vehicles");
            System.out.println("2. Rent vehicle");
            System.out.println("3. See list of rented vehicles");
            System.out.println("4. Return vehicle");
            System.out.println("5. Exit\n");
            System.out.println("Please make a choice using the numbers above");

            int menuChoice = 0;

            try {
                menuChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                // Ingen prompt då den ändå visas från default i switch case.. Kanske är fel men det såg konstigt ut.
            }

            switch (menuChoice) {
                case 1:
                    printVehicleList(vehicleList);
                    break;
                case 2:
                    rentVehicle();
                    break;
                case 3:
                    printRentedVehicleList(rentedVehicleList);
                    break;
                case 4:
                    returnVehicle();
                    break;
                case 5:
                    System.out.println("Thanks for choosing CarRental! Please come again!");
                    return;
                default:
                    System.out.println("Please enter a valid option, numbers 1-5.\n");
            }

        }

    }

    public void rentVehicle(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter registration ID for the vehicle you want to rent");
        String selectedVehicle = scanner.nextLine().toUpperCase();

        if (vehicleList.containsKey(selectedVehicle)) {
            Vehicle vehicle = vehicleList.get(selectedVehicle);
            vehicle.rentVehicle();
            rentedVehicleList.put(selectedVehicle, vehicle);
            vehicleList.remove(selectedVehicle);
        } else {
            System.out.println("Vehicle not found\n");
        }
    }

    public void returnVehicle(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter registration ID for the vehicle you want to return");
        String returnedVehicle = scanner.nextLine().toUpperCase();

        if (rentedVehicleList.containsKey(returnedVehicle)) {
            Vehicle vehicle = rentedVehicleList.get(returnedVehicle);
            System.out.println("Enter number of days vehicle was rented");
            int rentedDays = Integer.parseInt(scanner.nextLine());
            returnPayment(returnedVehicle, rentedDays);
            vehicle.returnVehicle();
            vehicleList.put(returnedVehicle, vehicle);
            rentedVehicleList.remove(returnedVehicle);
        } else {
            System.out.println("Vehicle not found\n");
        }
    }

    public void returnPayment(String registrationID, int rentedDays){
        Vehicle vehicle = rentedVehicleList.get(registrationID);
        System.out.println("The price for the vehicle rented is: " + vehicle.calculateFee(rentedDays) + "\n");
    }

    public void printVehicleList(HashMap<String, Vehicle> vehicleList) {
        if (vehicleList.isEmpty()){
            System.out.println("No vehicles available\n");
        } else {
            System.out.println("These are the vehicles available:\n");
            for (Object vehicle : vehicleList.values()) {
                System.out.println(vehicle);
            }
            System.out.println();
        }
    }

    public void printRentedVehicleList(HashMap<String, Vehicle> rentedVehicleList) {
        if (rentedVehicleList.isEmpty()){
            System.out.println("No rented vehicles found\n");
        } else {
            System.out.println("These are the rented vehicles found:\n");
            for (Object vehicle : rentedVehicleList.values()) {
                System.out.println(vehicle);
            }
            System.out.println();
        }
    }


}
