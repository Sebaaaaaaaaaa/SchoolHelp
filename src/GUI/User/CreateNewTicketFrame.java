package GUI.User;

import java.awt.*;
import javax.swing.*;

public class CreateNewTicketFrame extends JFrame {

    public CreateNewTicketFrame() {
        setTitle("School Help - Create Ticket");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Create New Ticket");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel("Fill in the details to create a support ticket");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JLabel titleLbl = new JLabel("Title");
        titleLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        titleLbl.setForeground(new Color(80, 80, 80));
        titleLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextField titleField = new JTextField();
        titleField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        titleField.setAlignmentX(LEFT_ALIGNMENT);
        titleField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        JLabel descLbl = new JLabel("Description");
        descLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        descLbl.setForeground(new Color(80, 80, 80));
        descLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea descArea = new JTextArea(5, 0);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JScrollPane descScroll = new JScrollPane(descArea);
        descScroll.setAlignmentX(LEFT_ALIGNMENT);
        descScroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        descScroll.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(2, 2, 2, 2)));

        JLabel prioLbl = new JLabel("Priority");
        prioLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        prioLbl.setForeground(new Color(80, 80, 80));
        prioLbl.setAlignmentX(LEFT_ALIGNMENT);

        JComboBox<String> prioCombo = new JComboBox<>(new String[] { "High", "Medium", "Low", "Critical" });
        prioCombo.setBackground(Color.WHITE);
        prioCombo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        prioCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        prioCombo.setAlignmentX(LEFT_ALIGNMENT);

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btns.setBackground(Color.WHITE);
        btns.setAlignmentX(LEFT_ALIGNMENT);
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btns.add(btn("Create Ticket", new Color(0, 120, 215)));
        btns.add(btn("Cancel", new Color(150, 150, 150)));

        p.add(title);
        p.add(Box.createVerticalStrut(5));
        p.add(sub);
        p.add(Box.createVerticalStrut(20));
        p.add(titleLbl);
        p.add(Box.createVerticalStrut(5));
        p.add(titleField);
        p.add(Box.createVerticalStrut(15));
        p.add(descLbl);
        p.add(Box.createVerticalStrut(5));
        p.add(descScroll);
        p.add(Box.createVerticalStrut(15));
        p.add(prioLbl);
        p.add(Box.createVerticalStrut(5));
        p.add(prioCombo);
        p.add(Box.createVerticalStrut(20));
        p.add(btns);

        add(p);
    }

    private JButton btn(String text, Color bg) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreateNewTicketFrame().setVisible(true));
    }
}