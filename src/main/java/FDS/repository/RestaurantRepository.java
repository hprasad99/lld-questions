package FDS.repository;

import FDS.entity.Restaurant;

import java.util.Arrays;
import java.util.List;

public interface RestaurantRepository {
    void addRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(int id);
    void updateRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();
}
