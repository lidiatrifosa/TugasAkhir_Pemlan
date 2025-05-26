package GUI;

import tabungan.*;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;


public class FormTransaksi extends JFrame {
    public FormTransaksi(Tabungan tabungan) {
        setTitle("Tambah Transaksi");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel utama dengan padding dan warna
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 250, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Form Tambah Transaksi", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(new Color(33, 102, 172));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        JLabel lblJenis = new JLabel("Jenis:");
        lblJenis.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblJenis, gbc);

        String[] jenis = {"Pemasukan", "Pengeluaran"};
        JComboBox<String> cbJenis = new JComboBox<>(jenis);
        cbJenis.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(cbJenis, gbc);

        JLabel lblJumlah = new JLabel("Jumlah:");
        lblJumlah.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(lblJumlah, gbc);

        JTextField tfJumlah = new JTextField();
        tfJumlah.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(tfJumlah, gbc);

        JLabel lblKet = new JLabel("Keterangan:");
        lblKet.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(lblKet, gbc);

        JTextField tfKet = new JTextField();
        tfKet.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(tfKet, gbc);

        JLabel lblTanggal = new JLabel("Tanggal: " + LocalDate.now());
        lblTanggal.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblTanggal.setForeground(new Color(120, 120, 120));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(lblTanggal, gbc);

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBackground(new Color(33, 150, 243));
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(btnSimpan, gbc);

        add(panel);

        btnSimpan.addActionListener(e -> {
            try {
                String jumlahStr = tfJumlah.getText().trim();
                String ket = tfKet.getText().trim();
                if (jumlahStr.isEmpty() || ket.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                double jumlah = Double.parseDouble(jumlahStr);
                if (jumlah <= 0) {
                    JOptionPane.showMessageDialog(this, "Jumlah harus lebih dari 0!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Transaksi transaksi;
                if (cbJenis.getSelectedItem().equals("Pemasukan")) {
                    transaksi = new Pemasukan(jumlah, ket, LocalDate.now());
                } else {
                    transaksi = new Pengeluaran(jumlah, ket, LocalDate.now());
                }
                tabungan.tambahTransaksi(transaksi);
                transaksi.tampilkanDetail(); // Gunakan method dari Transaksi
                JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!\n" +
                        "Detail:\n" +
                        "Jenis: " + cbJenis.getSelectedItem() + "\n" +
                        "Jumlah: Rp" + jumlah + "\n" +
                        "Keterangan: " + ket + "\n" +
                        "Tanggal: " + LocalDate.now(),
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan angka valid untuk jumlah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}