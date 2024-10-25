package UTS;

import java.util.List;

class Food {
    String name;
    double price;
    List<String> ingredients;
    int cookingTime; // Cooking time in seconds

    public Food(String name, double price, List<String> ingredients, int cookingTime) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.cookingTime = cookingTime;
    }
}
