package CarRental;

// Subklass för bilar som extendar vehicle
public class Car extends Vehicle {
    // Unik variabel för antal dörrar för bilar
    int doors;

    // Konstruktor för bilobjekt
    public Car(String registrationID, String brand, String modelId, int pricePerDay, String vehicleColor, int doors) {
        super(registrationID, brand, modelId, pricePerDay, vehicleColor);
        this.doors = doors;
    }

    // Metod för att hyra bil som overridar vehicle
    @Override
    public void rentVehicle() {
        System.out.println("You have rented car: " + getBrand() + ": " + getRegistrationID() + "\n");
    }

    // Metod för att returnera bil som overridar vehicle
    @Override
    public void returnVehicle() {
        System.out.println("You have returned car: " + getBrand() + ": " + getRegistrationID() + "\n");
    }

}
