package GUI.Technician;

import java.awt.*;
import javax.swing.*;

public class TechnicianDashboard extends JFrame {

    public TechnicianDashboard() {
        setTitle("School Help");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 240);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(20, 25, 15, 25));

        JLabel title = new JLabel("School Help");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel sub = new JLabel("Technician panel");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        sub.setForeground(new Color(60, 60, 60));
        sub.setAlignmentX(CENTER_ALIGNMENT);

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("SansSerif", Font.PLAIN, 11));
        footer.setForeground(new Color(80, 80, 80));
        footer.setAlignmentX(CENTER_ALIGNMENT);

        p.add(title);
        p.add(Box.createVerticalStrut(4));
        p.add(sub);
        p.add(Box.createVerticalStrut(18));
        p.add(btn("View Unassigned Tickets"));
        p.add(Box.createVerticalStrut(8));
        p.add(btn("View My Tickets"));
        p.add(Box.createVerticalStrut(8));
        p.add(btn("Logout"));
        p.add(Box.createVerticalStrut(14));
        p.add(footer);

        add(p);
    }

    private JButton btn(String t) { JButton b = new JButton(t); b.setFont(new Font("SansSerif", Font.PLAIN, 13)); b.setBackground(new Color(212, 208, 200)); b.setFocusPainted(false); b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32)); b.setAlignmentX(CENTER_ALIGNMENT); return b; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TechnicianDashboard().setVisible(true));
    }
}

