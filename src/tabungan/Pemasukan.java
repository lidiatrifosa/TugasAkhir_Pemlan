package tabungan;
import java.time.LocalDate;

public class Pemasukan extends Transaksi {
    public Pemasukan(double jumlah, String keterangan, LocalDate tanggal) {
        super(jumlah, keterangan, tanggal);
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("[+] Pemasukan: Rp" + jumlah + " - " + keterangan + " (" + tanggal + ")");
    }
}

