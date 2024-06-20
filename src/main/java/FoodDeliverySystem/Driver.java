package FoodDeliverySystem;

import FoodDeliverySystem.entity.FoodItem;
import FoodDeliverySystem.entity.Restaurant;
import FoodDeliverySystem.service.OrderService;
import FoodDeliverySystem.service.RestaurantService;
import FoodDeliverySystem.service.impl.OrderServiceImpl;
import FoodDeliverySystem.service.impl.RestaurantServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // todo: Register Restaurants
        List<String> pinCodes = Arrays.asList("101", "102");
        List<FoodItem> foodItems = Arrays.asList(
                new FoodItem("Pizza" , 120.0, 12),
                new FoodItem("Burger", 110.20, 20)
        );

        restaurantService.registerRestaurant("Meghana Foods", pinCodes, foodItems);

        // todo: Update food quantity
        restaurantService.updateQuantity("Meghana Foods", "Pizza", 7);

        // todo: Rate Restaurant
        restaurantService.rateRestaurants("Meghana Foods", 5, "Excellent Food");

        // todo: Show restaurants
        List<Restaurant> restaurants = restaurantService.showRestaurants("rating");

        // todo: Place Order

        // todo: Fetch Order
    }
}

/*
Register Restaurant :  Register_restaurant(resturant_name, list of serviceable pin-codes, List<food item name, food item price, initial quantity>).
Restaurant owners should be able to increase the quantity of the food item. update_quantity(restaurant name, food name, quantity to Add)
Users should be able to rate(1(Lowest)-5(Highest)) any restaurant with or without comment. rate_restaurant(restaurant name, rating, comment)
User should be able to get list of all serviceable restaurant, food item name and price in descending order: show_restaurant(rating/price,itemname?) Based on rating Based on Price
A restaurant is serviceable when it delivers to the user's pincode and has non-zero quantity of food item. Place an order from any restaurant with any allowed quantity. place_order(restaurant name, List<food name, quantity>)
Order History of User: For a given user you should be able to fetch order history.
 */