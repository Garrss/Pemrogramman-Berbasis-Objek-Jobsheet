package UTS;

class CleaningEmployee extends Employee {
    public CleaningEmployee() {
        super("Adam"); // Fixed name for cleaning employee
    }

    public void clean(Customer customer) {
        System.out.println(name + " is cleaning up after " + customer.name + ".");
    }
}
