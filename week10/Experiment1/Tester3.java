package week10.Experiment1;

public class Tester3 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "A-1");
        @SuppressWarnings("unused")
        Employee e[] = { pEmp, iEmp };
        @SuppressWarnings("unused")
        Payable p[] = { pEmp, eBill };
        // Employee e2[] = { pEmp, iEmp, eBill };
    }
}
