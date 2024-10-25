package UTS;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Sample ingredients for food
        List<String> burgerIngredients = Arrays.asList("Bun", "Patty", "Lettuce", "Tomato");
        List<String> friesIngredients = Arrays.asList("Potato", "Salt");
        List<String> drinkIngredients = Arrays.asList("Water", "Sugar");

        // Create food items with prices in Rupiah (Rp)
        Food burger = new Food("Burger", 30000, burgerIngredients, 10); // Rp. 30,000
        Food fries = new Food("Fries", 20000, friesIngredients, 5); // Rp. 20,000
        Food drink = new Food("Drink", 10000, drinkIngredients, 2); // Rp. 10,000

        // Create a list of available menu items
        List<Food> menu = List.of(burger, fries, drink);

        // Create a restaurant with fixed employees
        Restaurant restaurant = new Restaurant("FastBites");

        // Track the number of orders processed
        int orderCount = 0;
        boolean isRunning = true;

        while (isRunning) {
            // Exit if the 10th order is completed
            if (orderCount >= restaurant.MAX_CUSTOMERS) {
                System.out.println("=====================================================");
                System.out.println("\n=== The restaurant has processed the 10th order ===");
                System.out.println("Game Over!");
                // Display total income and average customer satisfaction
                restaurant.showFinalResults();
                break;
            }

            // Simulate random customer arrivals
            System.out.println("==================================================");
            System.out.println("=== Welcome to FastBites Restaurant Simulation ===");
            System.out.println("==================================================");
            System.out.println("1. Manage orders");
            System.out.println("2. Check inventory");
            System.out.println("3. Restock inventory");
            System.out.println("4. Measure customer satisfaction");
            System.out.println("5. Check total income");
            System.out.println("6. Close restaurant");
            System.out.println("==================================================");
            System.out.print("Choose an action: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Manage orders with Amanda serving, Adit cooking, and Adam cleaning
                    restaurant.manageOrders(menu);
                    orderCount++; // Increment the order count after managing an order
                    System.out.println("Orders processed: " + orderCount);
                    break;

                case 2:
                    // Check inventory
                    restaurant.checkInventory();
                    break;

                case 3:
                    // Restock inventory
                    restaurant.restockInventory();
                    break;

                case 4:
                    // Measure customer satisfaction
                    restaurant.measureSatisfaction();
                    break;

                case 5:
                    // Check total income
                    restaurant.checkIncome();
                    break;

                case 6:
                    // Close the restaurant
                    restaurant.closeRestaurant();
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid option! Please choose a valid action.");
            }

            // Add a random customer every few seconds (simulate random customer arrival)
            if (isRunning) {
                Thread.sleep((restaurant.rand.nextInt(5) + 1) * 1000); // Sleep for 1-5 seconds
                restaurant.addRandomCustomer(menu); // Only adds customers if less than 10 have arrived
            }
        }

        scanner.close();
    }
}
