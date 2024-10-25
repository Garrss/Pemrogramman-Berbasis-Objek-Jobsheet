package UTS;

import java.util.List;
import java.util.Random;
import java.util.*;

class Customer {
    String name;
    int age;
    String gender;
    Map<Food, Integer> order; // Customer's food orders with quantity
    List<Food> foodPreference; // Customer's food preferences
    int patienceLevel; // Patience level before leaving
    int satisfactionScore = 0;
    Random rand = new Random();

    public Customer(String name, int age, String gender, List<Food> foodPreference, int patienceLevel) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.foodPreference = foodPreference;
        this.order = new HashMap<>();
        this.patienceLevel = patienceLevel;
    }

    // Customer randomly chooses multiple items and their quantities
    public void chooseMenuItems() {
        int numberOfOrders = rand.nextInt(foodPreference.size()) + 1; // At least 1 item

        // Choose multiple menu items and their quantities
        for (int i = 0; i < numberOfOrders; i++) {
            Food foodItem = foodPreference.get(rand.nextInt(foodPreference.size()));
            int quantity = rand.nextInt(3) + 1; // Quantity between 1 and 3
            if (order.containsKey(foodItem)) {
                order.put(foodItem, order.get(foodItem) + quantity); // Add more quantity if already ordered
            } else {
                order.put(foodItem, quantity); // Add new item with quantity
            }
        }

        System.out.println(name + " ordered the following items:");
        for (Map.Entry<Food, Integer> entry : order.entrySet()) {
            System.out.println(entry.getKey().name + " x" + entry.getValue());
        }
    }

    // Simulate random time for the customer to enjoy their meal
    public void enjoyMeal() {
        int enjoymentTime = rand.nextInt(5) + 1; // Random time between 1-5 seconds
        System.out.println(name + " is enjoying the meal for " + enjoymentTime + " seconds.");
        try {
            Thread.sleep(enjoymentTime * 1000); // Simulate eating time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " has finished the meal.");
    }

    // Provide satisfaction rating
    public void provideSatisfaction() {
        satisfactionScore = rand.nextInt(5) + 1; // Random satisfaction score between 1 and 5
        System.out.println(name + " rated their satisfaction: " + satisfactionScore);
    }

    public int getSatisfactionScore() {
        return satisfactionScore;
    }
}
