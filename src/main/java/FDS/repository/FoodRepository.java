package FDS.repository;

import FDS.entity.Food;

public interface FoodRepository {
    void addOrUpdateFood(Food food);
    Food getFoodById(int id);
}
