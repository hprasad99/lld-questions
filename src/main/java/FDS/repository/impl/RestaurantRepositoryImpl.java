package FDS.repository.impl;

import FDS.entity.Restaurant;
import FDS.repository.RestaurantRepository;

import java.util.*;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final Map<Integer, Restaurant> restaurantMap = new HashMap<>();
    private int currentId = 1;
    @Override
    public void addRestaurant(Restaurant restaurant) {

    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return null;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {

    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurantMap.values());
    }
}
