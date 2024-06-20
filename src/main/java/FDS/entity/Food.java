package FDS.entity;

public class Food {
    private int id;
    private String name;
    private int qty;
    private int restaurantId;

    public Food(int id, String name, int qty, int restaurantId) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.restaurantId = restaurantId;
    }

    public Food() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
