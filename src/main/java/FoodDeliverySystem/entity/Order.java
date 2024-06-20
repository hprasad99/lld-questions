package FoodDeliverySystem.entity;

import java.util.Map;

public class Order {
    String restaurantName;
    Map<String, Integer> foodItems;

    public Order(String restaurantName, Map<String, Integer> foodItems) {
        this.restaurantName = restaurantName;
        this.foodItems = foodItems;
    }

}
