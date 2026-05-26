package GUI.User;

import java.awt.*;
import javax.swing.*;

public class OpenedTicketsFrame extends JFrame {

    public OpenedTicketsFrame() {
        setTitle("School Help - Opened Tickets");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Opened Tickets");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel("1 ticket(s) total");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        sep.setAlignmentX(LEFT_ALIGNMENT);
        sep.setForeground(new Color(230, 230, 230));

        JLabel ticketName = new JLabel("Ticket 1");
        ticketName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        ticketName.setForeground(new Color(40, 40, 40));
        ticketName.setAlignmentX(LEFT_ALIGNMENT);

        JLabel ticketDate = new JLabel("Created on Jan 4, 2026, 12:24 PM");
        ticketDate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ticketDate.setForeground(new Color(120, 120, 120));
        ticketDate.setAlignmentX(LEFT_ALIGNMENT);

        JPanel content = new JPanel(new BorderLayout(15, 0));
        content.setBackground(Color.WHITE);
        content.setAlignmentX(LEFT_ALIGNMENT);
        content.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));

        JPanel leftBtns = new JPanel();
        leftBtns.setLayout(new BoxLayout(leftBtns, BoxLayout.Y_AXIS));
        leftBtns.setBackground(Color.WHITE);
        leftBtns.add(btn("Ticket Status", new Color(0, 120, 215)));
        leftBtns.add(Box.createVerticalStrut(8));
        leftBtns.add(btn("Add Comment", new Color(0, 120, 215)));
        leftBtns.add(Box.createVerticalStrut(8));
        leftBtns.add(btn("Close Ticket", new Color(200, 50, 50)));
        leftBtns.add(Box.createVerticalStrut(8));
        leftBtns.add(btn("Give Feedback", new Color(100, 180, 100)));

        JTextArea desc = new JTextArea("The problem is...");
        desc.setEditable(false);
        desc.setBackground(new Color(245, 245, 245));
        desc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        desc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JScrollPane ds = new JScrollPane(desc);
        ds.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        content.add(leftBtns, BorderLayout.WEST);
        content.add(ds, BorderLayout.CENTER);

        JPanel bottomRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        bottomRow.setBackground(Color.WHITE);
        bottomRow.setAlignmentX(LEFT_ALIGNMENT);
        bottomRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        bottomRow.add(btn("Cancel", new Color(150, 150, 150)));

        p.add(title);
        p.add(Box.createVerticalStrut(5));
        p.add(sub);
        p.add(Box.createVerticalStrut(15));
        p.add(sep);
        p.add(Box.createVerticalStrut(20));
        p.add(ticketName);
        p.add(Box.createVerticalStrut(5));
        p.add(ticketDate);
        p.add(Box.createVerticalStrut(15));
        p.add(content);
        p.add(Box.createVerticalStrut(25));
        p.add(bottomRow);

        add(p);
    }

    private JButton btn(String text, Color bg) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setPreferredSize(new Dimension(140, 36));
        b.setMaximumSize(new Dimension(140, 36));
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OpenedTicketsFrame().setVisible(true));
    }
}

