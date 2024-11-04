package Week9.Experiment1;

public class Program {
    public static void main(String[] args) {
        Cat asiacat = new Cat();
        Fish dolphin = new Fish();

        People john = new People("John");
        People ben = new People("Ben");

        john.setPet(asiacat);
        ben.setPet(dolphin);

        john.takePetToWalk();
        ben.takePetToWalk();
    }

}
