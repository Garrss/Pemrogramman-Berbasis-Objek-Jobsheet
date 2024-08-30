package Week1.Assignment;

public class MobilJimny extends Mobil {
    private String tipemobil;

    public void setTipeMobil(String newValue) {
        tipemobil = newValue;
    }

    public void cetakStatus() {
        super.cetakStatus();
        System.out.println("Tipe Mobil: " + tipemobil);
    }
}
