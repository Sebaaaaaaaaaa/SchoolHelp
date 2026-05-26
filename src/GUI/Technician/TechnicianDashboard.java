package GUI.Technician;

import java.awt.*;
import javax.swing.*;

public class TechnicianDashboard extends JFrame {

    public TechnicianDashboard() {
        setTitle("School Help - Technician Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 360);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("School Help");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel sub = new JLabel("Technician Panel");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(CENTER_ALIGNMENT);

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(new Color(150, 150, 150));
        footer.setAlignmentX(CENTER_ALIGNMENT);

        p.add(title);
        p.add(Box.createVerticalStrut(5));
        p.add(sub);
        p.add(Box.createVerticalStrut(25));
        p.add(btn("View Unassigned Tickets"));
        p.add(Box.createVerticalStrut(10));
        p.add(btn("View My Tickets"));
        p.add(Box.createVerticalStrut(10));
        p.add(btn("Logout"));
        p.add(Box.createVerticalStrut(20));
        p.add(footer);

        add(p);
    }

    private JButton btn(String t) {
        JButton b = new JButton(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(new Color(0, 120, 215));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        b.setAlignmentX(CENTER_ALIGNMENT);
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if (t.equals("Logout")) {
            b.setBackground(new Color(200, 50, 50)); // Red for logout
        }

        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TechnicianDashboard().setVisible(true));
    }
}
