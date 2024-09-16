package Week3;

public class Demo {
    public static void main(String[] args) {
        Member member1 = new Member("Ika ", "Batu");
        System.out.println("Deposit: " + member1.getName() + "Rp. " + member1.getDeposit());

        member1.setname("Iwan");
        member1.setaddress("Malang");
        member1.Deposit(1000000);
        System.out.println("Deposito " + member1.getName() + "Rp. " + member1.getDeposit());

        member1.loan(500000);
        System.out.println("Deposito " + member1.getName() + "Rp. " + member1.getDeposit());
    }
}