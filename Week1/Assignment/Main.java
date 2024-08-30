package Week1.Assignment;

public class Main {
    public static void main(String[] args) {
        MobilJimny mbl1 = new MobilJimny();
        MobilJazz mbl2 = new MobilJazz();

        mbl1.setNama("Jimny");
        mbl1.setMerek("Suzuki");
        mbl1.setWarna("Hitam");
        mbl1.setTransmisi("manual");
        mbl1.tambahKecepatan(70);
        mbl1.setTahun(1993);
        mbl1.setTipeMobil("Jeep");
        mbl1.cetakStatus();
        System.out.println("=============================");

        mbl2.setNama("Jazz");
        mbl2.setMerek("Honda");
        mbl2.setWarna("Merah");
        mbl2.setTransmisi("matic");
        mbl2.tambahKecepatan(80);
        mbl2.setTahun(2015);
        mbl2.setTipeMobil("Hatchback");
        mbl2.cetakStatus();
        System.out.println("=============================");

        Pena pena = new Pena();
        pena.setBrand("Snowman");
        pena.setWarna("Hitam");
        pena.setHarga(4000);
        pena.cetakStatus();
        System.out.println("=============================");

        Penghapus penghapus = new Penghapus();
        penghapus.setBrand("Joyko");
        penghapus.setWarna("Putih");
        penghapus.setHarga(3000);
        penghapus.cetakStatus();
        System.out.println("=============================");
    }
}
