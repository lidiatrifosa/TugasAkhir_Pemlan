package tabungan;

import java.time.LocalDate;

 public class Pengeluaran extends Transaksi {
    public Pengeluaran(double jumlah, String keterangan, LocalDate tanggal) {
        super(jumlah, keterangan, tanggal);
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("[-] Pengeluaran: Rp" + jumlah + " - " + keterangan + " (" + tanggal + ")");
    }
}

