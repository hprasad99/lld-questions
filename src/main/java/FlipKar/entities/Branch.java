package FlipKar.entities;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Vehicle> vehicles;
    private List<Booking> bookings;

    public Branch(String name, List<Vehicle> vehicles) {
        this.name = name;
        this.vehicles = new ArrayList<>(vehicles);
        this.bookings = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}
