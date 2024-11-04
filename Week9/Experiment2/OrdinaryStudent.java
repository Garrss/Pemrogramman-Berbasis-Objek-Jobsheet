package Week9.Experiment2;

public class OrdinaryStudent extends Student {

    public OrdinaryStudent(String name) {
        super(name);
    }

    public void getGPA() {
        System.out.println("My GPA is 3,1");
    }

    @Override
    public void studyInCampus() {
        System.out.println("I am an ordinary student, my name is " + this.name);
    }
}
