package FDS.service;

import FDS.entity.Food;

public interface FoodService {
    void addOrUpdateFood(Food food);
    Food getFoodById(int id);
}
