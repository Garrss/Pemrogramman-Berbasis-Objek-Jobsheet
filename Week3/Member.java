package Week3;

public class Member {
    private String name;
    private String address;
    private float Deposit;

    Member(String name, String address) {
        this.name = name;
        this.address = address;
        this.Deposit = 0;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getDeposit() {
        return Deposit;
    }

    public void Deposit(float money) {
        Deposit += money;
    }

    public void loan(float money) {
        Deposit -= money;
    }
}
