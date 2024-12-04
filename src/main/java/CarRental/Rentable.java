package CarRental;

// Interface med metoder för rentvehicle, returnvehicle och calculatefee.
public interface Rentable {

    void rentVehicle();

    void returnVehicle();

    double calculateFee(int rentalDays);

}
