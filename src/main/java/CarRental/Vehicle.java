package CarRental;

import java.util.HashSet;

// Abstrakt klass vehicle som implementar interface Rentable
public abstract class Vehicle implements Rentable {
    // Variabler för alla subklasser till vehicle
    private String registrationID;
    private String brand;
    private String modelId;
    private int pricePerDay;
    private String vehicleColor;


    // Konstruktor för alla subklasser
    public Vehicle(String registrationID,String brand,String modelId, int pricePerDay, String vehicleColor) {
        this.registrationID = registrationID;
        this.brand = brand;
        this.modelId = modelId;
        this.pricePerDay = pricePerDay;
        this.vehicleColor = vehicleColor;
    }


    // Getters och setters
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

    // Metod för att räkna ut totalpriset för alla vehicles/subklasser
    public double calculateFee(int rentalDays) {
        return pricePerDay * rentalDays;
    }

    // toString metod som returnerar formaterad sträng med information om vehicle objektens värden istället för bara en hashkod vid tex system.out.println(vehicle)
    public String toString() {
        return "Regnr: " + registrationID + ", Märke: " + brand + ", Modell: " + modelId + ", Pris/dag: " + pricePerDay + " SEK, Färg: " + vehicleColor;
    }

}
