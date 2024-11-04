package Week9.Experiment2;

public class Program {

    public static void main(String[] args) {
        Rector MrRector = new Rector();

        // OrdinaryStudent ordinaryStudent = new OrdinaryStudent("Charlie");
        Undergraduated undergraduatedCumlaude = new Undergraduated("Joe");
        Postgraduated postgraduatedCumlaude = new Postgraduated("Ben");

        // MrRector.giveOrdinaryCertificate(ordinaryStudent);
        // MrRector.giveCumlaudeCertificate(undergraduatedCumlaude);
        // MrRector.giveCumlaudeCertificate(postgraduatedCumlaude);

        MrRector.giveCertifateOfTopStudent(postgraduatedCumlaude);
        MrRector.giveCertifateOfTopStudent(undergraduatedCumlaude);

    }
}
