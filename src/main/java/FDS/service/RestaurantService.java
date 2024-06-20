package FDS.service;

import FDS.entity.Restaurant;

public interface RestaurantService {
    void addRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(int id);
    void rateRestaurant(int id, float rating);
}
