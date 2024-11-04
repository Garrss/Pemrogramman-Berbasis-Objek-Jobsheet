package Week9.Experiment2;

public class Rector {
    public void giveCumlaudeCertificate(ICumlaude student) {
        System.out.println("I am a Rector, give a Cumlaude Certificate");
        System.out.println("Congratulations! Please introduce yourself..");

        if (student instanceof Student) {
            ((Student) student).studyInCampus();
        }

        student.graduate();
        student.getHighGPA();

        System.out.println("------------------------------------------------");
    }

    public void giveOrdinaryCertificate(OrdinaryStudent student) {
        System.out.println("I am a Rector, giving a Certificate of Attendance");
        System.out.println("Hello! Please introduce yourself..");

        student.studyInCampus();
        student.getGPA();

        System.out.println("------------------------------------------------");
    }

    public void giveCertifateOfTopStudent(IAchievers student) {
        System.out.println("I am a Rector, give a Certificate of Top Student.");
        System.out.println("Congratulations! How you can get achievement");

        student.winTheCompetition();
        student.publishTheJournal();

        System.out.println("-------------------------------------------------");
    }
}
