package CarRental;

// Subklass för bilar som extendar vehicle
public class Motorcycle extends Vehicle {
    // Unik variabel för antal hjul för motorcyklar
    int wheels;

    // Konstruktor för bilobjekt
    public Motorcycle(String registrationID, String brand, String modelId, int pricePerDay, String vehicleColor, int wheels) {
        super(registrationID, brand, modelId, pricePerDay, vehicleColor);
        this.wheels = wheels;
    }

    // Metod för att hyra motorcykel som overridar vehicle
    @Override
    public void rentVehicle() {
        System.out.println("You have rented motorcycle: " + getBrand() + ": " + getRegistrationID() + "\n");
    }

    // Metod för att returnera motorcykel som overridar vehicle
    @Override
    public void returnVehicle() {
        System.out.println("You have returned motorcycle: " + getBrand() + ": " + getRegistrationID() + "\n");
    }

}
