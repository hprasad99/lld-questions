package FDS.service.impl;

import FDS.entity.Restaurant;
import FDS.repository.RestaurantRepository;
import FDS.service.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {

    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return null;
    }

    @Override
    public void rateRestaurant(int id, float rating) {

    }
}
