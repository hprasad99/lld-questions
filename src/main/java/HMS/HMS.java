package HMS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HMS {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    public static void main(String[] args) {
        try {
            rooms.add(new Room(101, "Single", 100.00));
            rooms.add(new Room(102, "Double", 150.00));

            customers.add(new Customer(1, "Raj Kadam", "raj@email.com"));
            customers.add(new Customer(2, "Ravi Raj", "ravi@email.com"));
            Booking booking = new Booking(1, 1, 101, new Date(), new Date(System.currentTimeMillis() + 86400000), 100.00, "Booked");
            bookings.add(booking);

            for (Booking b : bookings) {
                if (b.getCustomerId() == 1) {
                    System.out.println("Found booking for customer ID 1: Room ID " + b.getRoomId() +
                            ", Start Date: " + b.getStartDate() + ", End Date: " + b.getEndDate() +
                            ", Total Price: Rs" + b.getTotalPrice() + ", Status: " + b.getStatus());
                }
            }
        } catch (Exception ex) {
            System.err.println("An error occured in HMS platform " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
