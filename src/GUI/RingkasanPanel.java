package GUI;
import javax.swing.*;
import tabungan.*;
import java.awt.*;


public class RingkasanPanel extends JFrame {
    public RingkasanPanel(Tabungan tabungan) {
        setTitle("Ringkasan Tabungan");
        setSize(400, 260);
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
        gbc.gridx = 0;

        JLabel lblTitle = new JLabel("Ringkasan Tabungan", JLabel.CENTER);
        lblTitle.setFont(new Font("Montserrat", Font.BOLD, 22));
        lblTitle.setForeground(new Color(33, 102, 172));
        gbc.gridy = 0;
        panel.add(lblTitle, gbc);

        JLabel lblSaldo = new JLabel("Saldo: Rp" + tabungan.totalSaldo(), JLabel.CENTER);
        lblSaldo.setFont(new Font("Montserrat", Font.PLAIN, 16));
        gbc.gridy = 1;
        panel.add(lblSaldo, gbc);

        JLabel lblSisa = new JLabel("Sisa Menuju Target: Rp" + tabungan.hitungSisaMenujuTarget(), JLabel.CENTER);
        lblSisa.setFont(new Font("Montserrat", Font.PLAIN, 16));
        gbc.gridy = 2;
        panel.add(lblSisa, gbc);

        JLabel lblSaran = new JLabel("Saran Tabungan/Minggu: Rp" + tabungan.saranTabunganMingguan(), JLabel.CENTER);
        lblSaran.setFont(new Font("Montserrat", Font.PLAIN, 16));
        gbc.gridy = 3;
        panel.add(lblSaran, gbc);

        setContentPane(panel);
    }
}