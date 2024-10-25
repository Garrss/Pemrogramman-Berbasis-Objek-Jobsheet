package UTS;

class Finance {
    private double totalIncome;

    // Constructor
    public Finance() {
        this.totalIncome = 0;
    }

    // Method to add income when a sale is made
    public void addIncome(double amount) {
        totalIncome += amount;
        System.out.println("Added income: Rp." + amount);
    }

    // Method to check the total income
    public double getTotalIncome() {
        return totalIncome;
    }
}
