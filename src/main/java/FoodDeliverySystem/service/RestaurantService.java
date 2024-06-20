package FoodDeliverySystem.service;


import FoodDeliverySystem.entity.FoodItem;
import FoodDeliverySystem.entity.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RestaurantService {


    Map<String, Restaurant> restaurants = new HashMap<>();
    Map<String, Restaurant> getRestaurants();
    /*
    todo: Register_restaurant(resturant_name, list of serviceable pin-codes, List<food item name, food item price, initial quantity>)
     */
    void registerRestaurant (String restaurantName, List<String> pinCodes, List<FoodItem> foodItems);

    /*
    todo: Restaurant owners should be able to increase the quantity of the food item. update_quantity(restaurant name, food name, quantity to Add)
     */
    void updateQuantity (String restaurantName, String foodName, int quantity);

    void rateRestaurants (String restaurantName, int rating, String comment);

    /*
        todo: Provide the list of basis the sortBy choice
     */
    List<Restaurant> showRestaurants(String sortBy);

    /*
        todo: Provide the list of serviceable restaurants
     */
    List<Restaurant> listServicableRestaurants(String pinCode);
}
