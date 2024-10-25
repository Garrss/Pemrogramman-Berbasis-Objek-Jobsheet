package UTS;

class ServingEmployee extends Employee {
    public ServingEmployee() {
        super("Amanda"); // Fixed name for serving employee
    }

    public void serve(Customer customer) {
        System.out.println(name + " is serving " + customer.name + "'s order.");
    }
}
