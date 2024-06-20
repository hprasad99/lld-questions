package FoodDeliverySystem.service.impl;

import FoodDeliverySystem.entity.FoodItem;
import FoodDeliverySystem.entity.Order;
import FoodDeliverySystem.entity.Restaurant;
import FoodDeliverySystem.entity.User;
import FoodDeliverySystem.service.OrderService;
import FoodDeliverySystem.service.RestaurantService;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    Map<String, User> users = new HashMap<>();

    @Override
    public void placeOrder(String userName, String restaurantName, Map<String, Integer> foodItem) {
        User user = users.computeIfAbsent(userName, k -> new User());
        user.getOrderHistory().add(new Order(restaurantName, foodItem));

        // update restaurant food quantities
        RestaurantService restaurantService = new RestaurantServiceImpl();
        Restaurant restaurant = restaurantService.getRestaurants().get(restaurantName);
        if(Objects.nonNull(restaurant)) {
            for(Map.Entry<String, Integer> entry: foodItem.entrySet()) {
                FoodItem item = restaurant.getMenu().get(entry.getKey());
                if(Objects.nonNull(item) && item.getQuantity() >= entry.getValue()) {
                    double qty = item.getQuantity();
                    qty -= entry.getValue();
                    item.setQuantity(qty);
                }
            }
        }
    }

    @Override
    public List<Order> fetchOrderHistory(String userName) {
        User user = users.get(userName);
        return (user != null) ? user.getOrderHistory() : new ArrayList<>();
    }
}
