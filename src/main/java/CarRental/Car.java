package CarRental;

public class Car extends Vehicle {
    int doors;

    public Car(String registrationID, String brand, String modelId, int pricePerDay, String vehicleColor, int doors) {
        super(registrationID, brand, modelId, pricePerDay, vehicleColor);
        this.doors = doors;
    }

    @Override
    public void rentVehicle() {
        System.out.println("You have rented car: " + getBrand() + ": " + getRegistrationID() + "\n");
    }

    @Override
    public void returnVehicle() {
        System.out.println("You have returned car: " + getBrand() + ": " + getRegistrationID() + "\n");
    }

    @Override
    public void calculateFee() {

    }

}
