package Week6.Trial1;

public class ClassB extends ClassA {
    protected int z;

    public void setZ(int z) {
        this.z = z;
    }

    public void getNilaiZ() {
        System.out.println("nilai Z:" + z);
    }

    public void getJumlah() {
        System.out.println("jumlah:" + (x + y + z));
    }
}
