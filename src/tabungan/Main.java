package tabungan;
import GUI.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String nama = JOptionPane.showInputDialog(null, "Masukkan nama Anda:", "Registrasi", JOptionPane.QUESTION_MESSAGE);
            if (nama == null || nama.trim().isEmpty()) nama = "Pengguna";
            double target = 0;
            boolean valid = false;
            while (!valid) {
                String targetStr = JOptionPane.showInputDialog(null, "Masukkan target tabungan bulanan Anda:", "Target Tabungan", JOptionPane.QUESTION_MESSAGE);
                if (targetStr == null) System.exit(0);
                try {
                    target = Double.parseDouble(targetStr);
                    if (target > 0) valid = true;
                    else JOptionPane.showMessageDialog(null, "Target harus lebih dari 0!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            User user = new User(nama, target);
            new MainFrame(user).setVisible(true);
        });
    }
}