package Week2;

public class Rental {
    private int id;
    private String memberName;
    private String gameName;
    private double price;

    public void displayData() {
        System.out.println("Transaction id : " + id);
        System.out.println("Member name : " + memberName);
        System.out.println("Game name : " + gameName);
        System.out.println("Price : " + price);
    }

    public double AmountPay(double rentDuration) {
        return rentDuration * price;
    }
}
