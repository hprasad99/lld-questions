package FoodDeliverySystem.service;

import FoodDeliverySystem.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    void placeOrder(String userName, String restaurantName, Map<String, Integer> foodItem);
    List<Order> fetchOrderHistory(String userName);
}