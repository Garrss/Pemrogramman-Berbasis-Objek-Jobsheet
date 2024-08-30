package Week1.Assignment;

public class Penghapus {
    private String brand;
    private String warna;
    private int harga;

    public void setBrand(String newValue) {
        brand = newValue;
    }

    public void setWarna(String newValue) {
        warna = newValue;
    }

    public void setHarga(int increment) {
        harga = harga + increment;
    }

    public void cetakStatus() {
        System.out.println("Brand: " + brand);
        System.out.println("Warna: " + warna);
        System.out.println("Harga: " + harga);
    }
}
