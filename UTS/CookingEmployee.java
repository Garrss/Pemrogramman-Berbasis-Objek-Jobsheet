package UTS;

class CookingEmployee extends Employee {
    public CookingEmployee() {
        super("Adit"); // Fixed name for cooking employee
    }

    public void cook(Food food, int quantity) {
        // Calculate the total cooking time based on quantity ordered
        int totalCookingTime = food.cookingTime * quantity;

        // Print the estimated cooking time
        System.out.println(name + " is cooking " + food.name + " x" + quantity);
        System.out.println("Estimated cooking time: " + totalCookingTime + " seconds.");

        // Simulate the cooking time
        try {
            Thread.sleep(totalCookingTime * 1000); // Sleep for total cooking time in seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print message when the cooking is done
        System.out.println(food.name + " x" + quantity + " is ready.");
    }
}
