package CarRental;

public class Motorcycle extends Vehicle {
    int wheels;

    public Motorcycle(String registrationID, String brand, String modelId, int pricePerDay, String vehicleColor, int wheels) {
        super(registrationID, brand, modelId, pricePerDay, vehicleColor);
        this.wheels = wheels;
    }

    @Override
    public void rentVehicle() {
        System.out.println("You have rented motorcycle: " + getBrand() + ": " + getRegistrationID());
    }

    @Override
    public void returnVehicle() {
        System.out.println("You have returned motorcycle: " + getBrand() + ": " + getRegistrationID());
    }

    @Override
    public void calculateFee() {
        // ToDo - implement fee calculation
    }
}
