package FoodDeliverySystem.service.impl;

import FoodDeliverySystem.entity.FoodItem;
import FoodDeliverySystem.entity.Rating;
import FoodDeliverySystem.entity.Restaurant;
import FoodDeliverySystem.service.RestaurantService;

import java.util.*;

public class RestaurantServiceImpl implements RestaurantService {

    public Map<String, Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public void registerRestaurant(String restaurantName, List<String> pinCodes, List<FoodItem> foodItems) {
        Restaurant restaurant = new Restaurant(restaurantName, pinCodes);
        for(FoodItem foodItem: foodItems) {
            restaurant.getMenu().put(foodItem.getName(), foodItem);
        }
        restaurants.put(restaurantName, restaurant);
    }

    @Override
    public void updateQuantity(String restaurantName, String foodName, int quantity) {
        Restaurant restaurant = restaurants.get(restaurantName);
        if(Objects.nonNull(restaurant) && restaurant.getMenu().containsKey(foodName)) {
            FoodItem item = restaurant.getMenu().get(foodName);
            double availableQuantity = item.getQuantity();
            availableQuantity += quantity;
            item.setQuantity(availableQuantity);
        }
    }

    @Override
    public void rateRestaurants(String restaurantName, int rating, String comment) {
        Restaurant restaurant = new Restaurant(restaurantName);
        if(Objects.nonNull(restaurant)) {
            restaurant.getRatings().add(new Rating(rating, comment));
        }
    }

    // todo: show_restaurant(rating/price,itemname?) Based on rating Based on Price
    @Override
    public List<Restaurant> showRestaurants(String sortBy) {
        List<Restaurant> restaurantList = new ArrayList<>(restaurants.values());
        switch (sortBy.toLowerCase()) {
            case "rating" -> restaurantList.sort(Comparator.comparingDouble(Restaurant::getAverageRating).reversed());
            case "price" -> restaurantList.sort((r1, r2) -> {
                double avgPrice1 = r1.getMenu().values().stream().mapToDouble(item -> item.getPrice()).average().orElse(0.0);
                double avgPrice2 = r2.getMenu().values().stream().mapToDouble(item -> item.getPrice()).average().orElse(0.0);
                return Double.compare(avgPrice2, avgPrice1);
            });
            default -> System.err.println("Invalid sortBy option!");
        }
        return restaurantList;
    }

    @Override
    public List<Restaurant> listServicableRestaurants(String pinCode) {
        List<Restaurant> restaurantList = new ArrayList<>();
        for(Restaurant restaurant: restaurants.values()) {
            if(restaurant.getServiceablePinCodes().contains(pinCode)) {
                restaurantList.add(restaurant);
            }
        }
        return restaurantList;
    }
}
