package CarRental;

import java.util.HashSet;

public abstract class Vehicle implements Rentable {
    private String registrationID;
    private String brand;
    private String modelId;
    private int pricePerDay;
    private String vehicleColor;


    public Vehicle(String registrationID,String brand,String modelId, int pricePerDay, String vehicleColor) {
        this.registrationID = registrationID;
        this.brand = brand;
        this.modelId = modelId;
        this.pricePerDay = pricePerDay;
        this.vehicleColor = vehicleColor;
    }



    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }


    public void rentVehicle() {

    }

    public void returnVehicle() {

    }

    public double calculateFee(int rentalDays) {
        return pricePerDay * rentalDays;
    }

    public String toString() {
        return "Regnr: " + registrationID + ", Märke: " + brand + ", Modell: " + modelId + ", Pris/dag: " + pricePerDay + " SEK, Färg: " + vehicleColor;
    }

    public abstract void calculateFee();
}
