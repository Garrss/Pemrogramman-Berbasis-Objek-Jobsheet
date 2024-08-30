package Week1.Assignment;

public class Mobil {
    private String nama;
    private String merek;
    private String warna;
    private String transmisi;
    private int kecepatan;
    private int tahun;

    public void setNama(String newValue) {
        nama = newValue;
    }

    public void setMerek(String newValue) {
        merek = newValue;
    }

    public void setWarna(String newValue) {
        warna = newValue;
    }

    public void setTransmisi(String newValue) {
        transmisi = newValue;
    }

    public void tambahKecepatan(int increment) {
        kecepatan = kecepatan + increment;
    }

    public void rem(int decrement) {
        kecepatan = kecepatan - decrement;
    }

    public void setTahun(int increment) {
        tahun = tahun + increment;
    }

    public void cetakStatus() {
        System.out.println("Nama: " + nama);
        System.out.println("Merek: " + merek);
        System.out.println("Warna: " + warna);
        System.out.println("Transmisi: " + transmisi);
        System.out.println("Kecepatan: " + kecepatan);
        System.out.println("Tahun: " + tahun);
    }
}
