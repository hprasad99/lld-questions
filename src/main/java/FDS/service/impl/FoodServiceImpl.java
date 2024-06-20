package FDS.service.impl;

import FDS.entity.Food;
import FDS.repository.FoodRepository;
import FDS.service.FoodService;

public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void addOrUpdateFood(Food food) {

    }

    @Override
    public Food getFoodById(int id) {
        return null;
    }
}
