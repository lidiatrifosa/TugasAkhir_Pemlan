package tabungan;


public class User {
    private String nama;
    private double targetBulanan;
    private Tabungan tabungan;

    public User(String nama, double targetBulanan) {
        this.nama = nama;
        this.targetBulanan = targetBulanan;
        this.tabungan = new Tabungan();
        this.tabungan.setTarget(targetBulanan);
    }

    public Tabungan getTabungan() {
        return tabungan;
    }

    public String getNama() {
        return nama;
    }

    public double getTargetBulanan() {
        return targetBulanan;
    }
}