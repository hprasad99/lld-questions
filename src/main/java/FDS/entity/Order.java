package FDS.entity;

public class Order {
    private int id;
    private int userId;
    private int restaurantId;
    private int foodId;
    private int qty;

    public Order(int id, int userId, int restaurantId, int foodId, int qty) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.foodId = foodId;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
