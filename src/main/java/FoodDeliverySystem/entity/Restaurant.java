package FoodDeliverySystem.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Restaurant {
    String restaurantName;
    Map<String, FoodItem> menu;
    List<Rating> ratings;
    List<String> serviceablePinCodes;

    String address;

    public Restaurant(String restaurantName, Map<String, FoodItem> menu, List<Rating> ratings, List<String> serviceablePinCodes) {
        this.restaurantName = restaurantName;
        this.menu = menu;
        this.ratings = new ArrayList<>();
        this.serviceablePinCodes = serviceablePinCodes;
    }

    public double getAverageRating() {
        return ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);
    }

    public Restaurant(String restaurantName, List<String> serviceablePinCodes) {
        this.restaurantName = restaurantName;
        this.serviceablePinCodes = serviceablePinCodes;
    }

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getName() {
        return restaurantName;
    }

    public void setName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Map<String, FoodItem> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, FoodItem> menu) {
        this.menu = menu;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<String> getServiceablePinCodes() {
        return serviceablePinCodes;
    }

    public void setServiceablePinCodes(List<String> serviceablePinCodes) {
        this.serviceablePinCodes = serviceablePinCodes;
    }


}
