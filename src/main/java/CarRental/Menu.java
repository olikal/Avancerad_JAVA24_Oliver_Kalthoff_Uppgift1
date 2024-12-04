package CarRental;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Menu {
    // Initierar LinkedHashMap för tillgängliga fordon och en för hyrda fordon
    private HashMap<String, Vehicle> vehicleList = new LinkedHashMap<>();
    private HashMap<String, Vehicle> rentedVehicleList = new LinkedHashMap<>();

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        // Anropar skapaFordon metod som lägger till fordon i linkedhashmap vehicleList
        skapaFordon();

        System.out.println("--**|| Welcome to CarRental! ||**--\n");

        // While loop för menyn
        while (true){
            System.out.println("1. See list of available vehicles");
            System.out.println("2. Rent vehicle");
            System.out.println("3. See list of rented vehicles");
            System.out.println("4. Return vehicle");
            System.out.println("5. Exit\n");
            System.out.println("Please make a choice using the numbers above");

            // Initierar variabel som sparar menyval från användaren
            int menuChoice = 0;

            // Try catch som fångar ifall användaren matar in fel format
            try {
                // Scannar användarens input och sparar i menuChoice
                menuChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                // Ingen prompt då den ändå visas från default i switch case.. Kanske är fel men det såg konstigt ut?
            }

            // Switch case för menyval, 1-5 och en default ifall fel input anges
            switch (menuChoice) {
                case 1:
                    // Anropar metod som skriver ut hela vehicle-listan
                    printVehicleList(vehicleList);
                    break;
                case 2:
                    // Anropar metod för att hyra fordon
                    rentVehicle();
                    break;
                case 3:
                    // Anropar metod som skriver ut hela vehicle-listan för hyrda fordon
                    printRentedVehicleList(rentedVehicleList);
                    break;
                case 4:
                    // Anropar metod som används för att returnera fordon som hyrts
                    returnVehicle();
                    break;
                case 5:
                    // Stänger applikation
                    System.out.println("Thanks for choosing CarRental! Please come again!");
                    return;
                default:
                    // Promptar användaren att de skrivit in ett felaktigt alternativ
                    System.out.println("Please enter a valid option, numbers 1-5.\n");
            }

        }

    }
    // Skapar objekt av bilar och motorcyklar och lägger till dem i lista vehicleList
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

    /*
    Låter användaren skriva regnr på önskat fordon att hyra som sparas i versaler, sedan
    kontrollerar med if sats om input matchas med key i hashmap vehicleList.
    Om den hittas hämtas vehicle-objekt från listan, sedan körs metod rentVehicle.
    Därefter läggs fordonet till i rentedVehicleList och sedan tas fordonet bort från vehicleList.
    Om den inte hittas skrivs det ut till användaren.
     */
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

    /*
    Låter användaren skriva regnr på önskat fordon att returnera som sparas i versaler, sedan
    kontrollerar med ifsats om input matchas med key i hashmap rentedVehicleList.
    Om den hittas hämtas vehicle-objekt från listan.
    Användaren frågas om antal dagar fordonet hyrts.
    Kör returnPayment som räknar ut och skriver ut totalt pris.
    Kör metod returnVehicle.
    Därefter läggs fordonet till i vehicleList och sedan tas fordonet bort från rentedVehicleList.
    Om den inte hittas skrivs det ut till användaren.
     */
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

    /*
    Hämtar vehicle-objekt från listan.
    Anropar metoden calculateFee som räknar ut totalt pris och skriver ut till användaren
     */
    public void returnPayment(String registrationID, int rentedDays){
        Vehicle vehicle = rentedVehicleList.get(registrationID);
        System.out.println("The price for the vehicle rented is: " + vehicle.calculateFee(rentedDays) + "\n");
    }

    /*
    Kontrollerar om listan är tom, isf skrivs ut att listan är tom.
    Om listan inte är tom används en for each loop för att hämta och skriva ut alla tillgängliga fordon i listan.
     */
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

    /*
    Kontrollerar om listan är tom, isf skrivs ut att listan är tom.
    Om listan inte är tom används en for each loop för att hämta och skriva ut alla hyrda fordon i listan.
     */
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
