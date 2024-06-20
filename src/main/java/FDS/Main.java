package FDS;

import FDS.entity.Food;
import FDS.entity.Restaurant;
import FDS.repository.impl.FoodRepositoryImpl;
import FDS.repository.impl.OrderRepositoryImpl;
import FDS.repository.impl.RestaurantRepositoryImpl;
import FDS.service.FoodService;
import FDS.service.OrderService;
import FDS.service.RestaurantService;
import FDS.service.impl.FoodServiceImpl;
import FDS.service.impl.OrderServiceImpl;
import FDS.service.impl.RestaurantServiceImpl;

import java.util.Scanner;

public class Main {
    private static final RestaurantService restaurantService = new RestaurantServiceImpl(new RestaurantRepositoryImpl());
    private static final FoodService foodService = new FoodServiceImpl(new FoodRepositoryImpl());
    private static final OrderService orderService = new OrderServiceImpl(new OrderRepositoryImpl());

    private static void addRestaurant(Scanner scanner) {
        System.out.println("Enter restaurant name: ");
        String name = scanner.nextLine();
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurantService.addRestaurant(restaurant);
        System.out.println("Restaurant added successfully");
    }

    private static void addOrUpdateFoodQuantity(Scanner scanner) {
        System.out.println("Enter food name: ");
        String name = scanner.nextLine();
        System.out.println("Enter quantity: ");
        int qty = scanner.nextInt();
        System.out.println("Enter restaurant ID: ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();

        Food food = new Food();
        food.setName(name);
        food.setQty(qty);
        food.setRestaurantId(restaurantId);
        foodService.addOrUpdateFood(food);
        System.out.println("Food quantity updated successfully!");
    }

    private static void searchFoodOrRestaurantByRatings(Scanner scanner) {
        System.out.println("Enter minimum rating: ");
        float minRating = scanner.nextFloat();
        scanner.nextLine();

        RestaurantRepositoryImpl restaurantRepository = new RestaurantRepositoryImpl();
        restaurantRepository.getAllRestaurants().stream()
                .filter(r -> r.getRating() >= minRating)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            while(true) {
                System.out.println("1. Add Restaurant");
                System.out.println("2. Add or Update Food Quantity");
                System.out.println("3. Search Food Or Restaurant By Ratings");
                System.out.println("4. Order Food");
                System.out.println("5. Rate Restaurant");
                System.out.println("6. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addRestaurant(scanner);
                        break;
                    case 2:
                        addOrUpdateFoodQuantity(scanner);
                        break;
                    case 3:
                        searchFoodOrRestaurantByRatings(scanner);
                        break;
                    case 4:
                        orderFood(scanner);
                        break;
                    case 5:
                        rateRestaurant(scanner);
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.err.println("Invalid Choice");
                }
            }
        }
    }
}
