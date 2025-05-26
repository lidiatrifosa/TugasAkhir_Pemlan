package tabungan;
import java.util.ArrayList;

public class Tabungan implements AnalisisKeuangan {
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private double target;

    public void tambahTransaksi(Transaksi t) {
        daftarTransaksi.add(t);
    }

    public ArrayList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double totalSaldo() {
        double saldo = 0;
        for (Transaksi t : daftarTransaksi) {
            if (t instanceof Pemasukan) saldo += t.getJumlah();
            else if (t instanceof Pengeluaran) saldo -= t.getJumlah();
        }
        return saldo;
    }

    @Override
    public double hitungSisaMenujuTarget() {
        return Math.max(0, target - totalSaldo());
    }

    @Override
    public double saranTabunganMingguan() {
        return hitungSisaMenujuTarget() / 4.0;
    }
}