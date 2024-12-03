package CarRental;

public interface Rentable {

    void rentVehicle();

    void returnVehicle();

    double calculateFee(int rentalDays);


}
