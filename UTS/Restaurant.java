package UTS;

import java.util.*;

class Restaurant {
    String name;
    Queue<Customer> customers = new LinkedList<>();
    ServingEmployee servingEmployee;
    CookingEmployee cookingEmployee;
    CleaningEmployee cleaningEmployee;
    Finance finance; // Finance object to manage income
    int reputation = 5;
    boolean isOpen = true;
    int customerCount = 0; // Track the number of customers received
    final int MAX_CUSTOMERS = 10; // Limit to 10 customers
    Map<String, Integer> inventory = new HashMap<>(); // Inventory for ingredients
    List<Integer> satisfactionScores = new ArrayList<>(); // List to store all customer satisfaction scores
    Random rand = new Random();

    public Restaurant(String name) {
        this.name = name;
        this.servingEmployee = new ServingEmployee(); // Amanda
        this.cookingEmployee = new CookingEmployee(); // Adit
        this.cleaningEmployee = new CleaningEmployee(); // Adam
        this.finance = new Finance(); // Create a new Finance object
        initializeInventory();
    }

    // Initialize inventory with default quantities
    private void initializeInventory() {
        inventory.put("Bun", 50);
        inventory.put("Patty", 50);
        inventory.put("Lettuce", 50);
        inventory.put("Tomato", 50);
        inventory.put("Potato", 50);
        inventory.put("Salt", 50);
        inventory.put("Water", 50);
        inventory.put("Sugar", 50);
        System.out.println("Inventory initialized with default values.");
    }

    // Automatically add a random customer to the queue (max 10 customers)
    public void addRandomCustomer(List<Food> menu) {
        if (customerCount >= MAX_CUSTOMERS) {
            System.out.println("No more customers will be received. The restaurant has already received 10 customers.");
            return;
        }

        String[] names = { "John", "Alice", "Mark", "Sophia", "David", "Emma" };
        String[] genders = { "Male", "Female" };

        String name = names[rand.nextInt(names.length)];
        String gender = genders[rand.nextInt(genders.length)];
        int age = rand.nextInt(50) + 18; // Random age between 18 and 68
        int patienceLevel = rand.nextInt(10) + 1; // Random patience level between 1 and 10
        List<Food> foodPreference = getRandomFoodPreferences(menu);

        Customer newCustomer = new Customer(name, age, gender, foodPreference, patienceLevel);
        customers.offer(newCustomer);
        customerCount++; // Increment the customer count
        System.out.println(newCustomer.name + " has entered the restaurant with a patience level of " + patienceLevel);
    }

    // Randomly select food preferences for a customer
    private List<Food> getRandomFoodPreferences(List<Food> menu) {
        int numPreferences = rand.nextInt(menu.size()) + 1; // At least one preference
        Set<Food> selectedPreferences = new HashSet<>();
        while (selectedPreferences.size() < numPreferences) {
            selectedPreferences.add(menu.get(rand.nextInt(menu.size())));
        }
        return new ArrayList<>(selectedPreferences);
    }

    // Handle customer orders and processing
    public void manageOrders(List<Food> menu) {
        if (!customers.isEmpty()) {
            Customer customer = customers.poll();
            System.out.println(customer.name + " is ready to place an order.");

            // Customer randomly chooses multiple items and quantities
            customer.chooseMenuItems(); // Randomly selects multiple menu items and quantities

            // Amanda serves the order
            servingEmployee.serve(customer);

            // Check if we can prepare the order
            if (canPrepareOrder(customer.order)) {
                // Adit cooks the order
                for (Map.Entry<Food, Integer> entry : customer.order.entrySet()) {
                    Food food = entry.getKey();
                    int quantity = entry.getValue();
                    cookingEmployee.cook(food, quantity); // Cook each food item with quantity

                    // Deduct the ingredients used based on the quantity ordered
                    deductIngredients(food, quantity);
                }

                // Simulate customer enjoying the meal
                customer.enjoyMeal();

                // Provide satisfaction and track the score
                customer.provideSatisfaction();
                satisfactionScores.add(customer.getSatisfactionScore());

                // Adam cleans up after the customer
                cleaningEmployee.clean(customer);

                // Calculate the total sale and update the finance
                sellFood(customer);

            } else {
                System.out.println("Cannot prepare order due to insufficient ingredients.");
            }
        } else {
            System.out.println("No customers to manage right now.");
        }
    }

    // Calculate total sale for the customer's order and update finances
    private void sellFood(Customer customer) {
        double totalSale = 0;
        for (Map.Entry<Food, Integer> entry : customer.order.entrySet()) {
            Food food = entry.getKey();
            int quantity = entry.getValue();
            totalSale += food.price * quantity; // Calculate sale price based on quantity
        }
        System.out.println("Total sale for " + customer.name + "'s order: Rp." + totalSale);
        finance.addIncome(totalSale); // Add the total sale to the finance system
    }

    // Check if there are enough ingredients for the order
    private boolean canPrepareOrder(Map<Food, Integer> order) {
        for (Map.Entry<Food, Integer> entry : order.entrySet()) {
            Food food = entry.getKey();
            int quantity = entry.getValue();

            // Check if there's enough inventory for the required quantity
            for (String ingredient : food.ingredients) {
                if (!inventory.containsKey(ingredient) || inventory.get(ingredient) < quantity) {
                    System.out.println("Not enough " + ingredient + " in stock.");
                    return false;
                }
            }
        }
        return true;
    }

    // Deduct the required ingredients for the food
    private void deductIngredients(Food food, int quantity) {
        for (String ingredient : food.ingredients) {
            // Deduct the quantity of each ingredient
            int currentStock = inventory.get(ingredient);
            inventory.put(ingredient, currentStock - quantity);
            System.out.println(
                    "Deducted " + quantity + " units of " + ingredient + ". Remaining: " + inventory.get(ingredient));
        }
    }

    // Check the current inventory and display stock levels
    public void checkInventory() {
        System.out.println("=== Current Inventory ===");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " units");
        }
    }

    // Restock inventory with user input
    public void restockInventory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Restock Inventory ===");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Current stock of " + entry.getKey() + ": " + entry.getValue());
            System.out.print("Enter amount to restock " + entry.getKey() + ": ");
            int restockAmount = scanner.nextInt();
            inventory.put(entry.getKey(), inventory.get(entry.getKey()) + restockAmount);
        }
        System.out.println("Inventory restocked successfully.");
    }

    // Calculate average customer satisfaction and adjust reputation
    public void measureSatisfaction() {
        if (satisfactionScores.isEmpty()) {
            System.out.println("No satisfaction data available.");
            return;
        }

        double totalSatisfaction = 0;
        for (int score : satisfactionScores) {
            totalSatisfaction += score;
        }
        double averageSatisfaction = totalSatisfaction / satisfactionScores.size();
        System.out.printf("Average customer satisfaction: %.2f%n", averageSatisfaction);

        // Adjust reputation based on satisfaction
        if (averageSatisfaction >= 4) {
            reputation++;
        } else if (averageSatisfaction < 3) {
            reputation--;
        }
        System.out.println("Restaurant reputation: " + reputation);
    }

    // Method to check total income earned
    public void checkIncome() {
        double totalIncome = finance.getTotalIncome();
        System.out.printf("Total income earned by the restaurant: Rp.%.2f%n", totalIncome);
    }

    public void showFinalResults() {
        // Display total income
        double totalIncome = finance.getTotalIncome();
        System.out.printf("Total income earned by the restaurant: Rp. %.0f%n", totalIncome);

        // Calculate and display the average customer satisfaction score
        if (!satisfactionScores.isEmpty()) {
            double totalSatisfaction = 0;
            for (int score : satisfactionScores) {
                totalSatisfaction += score;
            }
            double averageSatisfaction = totalSatisfaction / satisfactionScores.size();
            System.out.printf("Average customer satisfaction score: %.2f out of 5%n", averageSatisfaction);
        } else {
            System.out.println("No customer satisfaction data available.");
        }
    }

    // Close the restaurant
    public void closeRestaurant() {
        isOpen = false;
        System.out.println("The restaurant is now closed.");
    }
}
