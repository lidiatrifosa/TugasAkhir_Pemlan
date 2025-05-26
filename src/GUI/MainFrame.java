package GUI;

import java.awt.*;
import javax.swing.*;
import tabungan.*;


public class MainFrame extends JFrame {
    private JButton btnTambah, btnLihatRingkasan;
    private Tabungan tabungan;

    public MainFrame(User user) {
        this.tabungan = user.getTabungan();
        setTitle("mySave - Aplikasi Tabungan Mahasiswa");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(240, 248, 255), 0, getHeight(), new Color(200, 220, 255));
                g2d.setPaint(gp);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
            }
        };
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(33, 102, 172), 2, true),
            BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 10, 12, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1;

        // Judul aplikasi
        JLabel lblTitle = new JLabel("mySave", JLabel.CENTER);
        lblTitle.setFont(new Font("Montserrat", Font.BOLD, 28));
        lblTitle.setForeground(new Color(33, 102, 172));
        gbc.gridy = 0;
        panel.add(lblTitle, gbc);

        // Subjudul/keterangan
        JLabel lblSub = new JLabel("Aplikasi Tabungan Mahasiswa", JLabel.CENTER);
        lblSub.setFont(new Font("Montserrat", Font.PLAIN, 16));
        lblSub.setForeground(new Color(60, 60, 60));
        gbc.gridy = 1;
        panel.add(lblSub, gbc);

        // Spacer
        gbc.gridy = 2;
        panel.add(Box.createVerticalStrut(10), gbc);

        // Tombol Tambah Transaksi
        btnTambah = new JButton("Tambah Transaksi");
        btnTambah.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnTambah.setBackground(new Color(33, 150, 243));
        btnTambah.setForeground(Color.WHITE);
        btnTambah.setFocusPainted(false);
        btnTambah.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        btnTambah.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 3;
        panel.add(btnTambah, gbc);

        // Spacer
        gbc.gridy = 4;
        panel.add(Box.createVerticalStrut(10), gbc);

        // Tombol Lihat Ringkasan
        btnLihatRingkasan = new JButton("Riwayat & Ringkasan");
        btnLihatRingkasan.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnLihatRingkasan.setBackground(new Color(76, 175, 80));
        btnLihatRingkasan.setForeground(Color.WHITE);
        btnLihatRingkasan.setFocusPainted(false);
        btnLihatRingkasan.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        btnLihatRingkasan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 5;
        panel.add(btnLihatRingkasan, gbc);

        btnTambah.addActionListener(e -> new FormTransaksi(tabungan).setVisible(true));
        btnLihatRingkasan.addActionListener(e -> new RingkasanPanel(tabungan).setVisible(true));

        setContentPane(panel);
    }
}