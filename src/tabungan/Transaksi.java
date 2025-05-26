package tabungan;

import java.time.LocalDate;

public abstract class Transaksi {
    protected double jumlah;
    protected String keterangan;
    protected LocalDate tanggal;

    public Transaksi(double jumlah, String keterangan, LocalDate tanggal) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }

    public double getJumlah() {
        return jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public abstract void tampilkanDetail();
}