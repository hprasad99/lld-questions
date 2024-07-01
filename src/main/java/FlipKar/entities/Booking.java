package FlipKar.entities;

import FlipKar.util.DateTimeUtil;

import java.time.LocalDateTime;

public class Booking {
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Booking(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(LocalDateTime start, LocalDateTime end) {
        return DateTimeUtil.overlaps(this.startTime, this.endTime, start, end);
    }
}
