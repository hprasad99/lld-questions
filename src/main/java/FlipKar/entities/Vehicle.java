package FlipKar.entities;

public abstract class Vehicle {
    private String type;
    private double pricePerHour;

    public Vehicle(String type, double pricePerHour) {
        this.type = type;
        this.pricePerHour = pricePerHour;
    }

    public String getType() {
        return type;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}
