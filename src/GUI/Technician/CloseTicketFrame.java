package GUI.Technician;

import java.awt.*;
import javax.swing.*;

public class CloseTicketFrame extends JFrame {

    public CloseTicketFrame() {
        setTitle("School Help – Close Ticket");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(340, 260);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(18, 18, 15, 18));

        JLabel title = new JLabel("Close Ticket #011");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel("Fill in the solution before closing");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        sub.setForeground(new Color(60, 60, 60));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JLabel solLbl = new JLabel("Solution adopted");
        solLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        solLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea area = new JTextArea(5, 0);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setAlignmentX(LEFT_ALIGNMENT);
        scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        btns.setBackground(new Color(212, 208, 200));
        btns.setAlignmentX(LEFT_ALIGNMENT);
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        btns.add(btn("Close Ticket"));
        btns.add(btn("Cancel"));

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("SansSerif", Font.PLAIN, 11));
        footer.setForeground(new Color(80, 80, 80));
        footer.setAlignmentX(CENTER_ALIGNMENT);

        p.add(title);
        p.add(Box.createVerticalStrut(3));
        p.add(sub);
        p.add(Box.createVerticalStrut(14));
        p.add(solLbl);
        p.add(Box.createVerticalStrut(4));
        p.add(scroll);
        p.add(Box.createVerticalStrut(14));
        p.add(btns);
        p.add(Box.createVerticalStrut(10));
        p.add(footer);

        add(p);
    }

    private JButton btn(String t) { JButton b = new JButton(t); b.setFont(new Font("SansSerif", Font.PLAIN, 12)); b.setBackground(new Color(212, 208, 200)); b.setFocusPainted(false); return b; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CloseTicketFrame().setVisible(true));
    }
}

