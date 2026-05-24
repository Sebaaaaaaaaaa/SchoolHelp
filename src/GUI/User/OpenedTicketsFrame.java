package GUI.User;

import java.awt.*;
import javax.swing.*;

public class OpenedTicketsFrame extends JFrame {

    public OpenedTicketsFrame() {
        setTitle("School Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 360);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel title = new JLabel("Opened Tickets");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel("1 ticket(s) total");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        sub.setForeground(new Color(60, 60, 60));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        sep.setAlignmentX(LEFT_ALIGNMENT);

        JLabel ticketName = new JLabel("Ticket 1");
        ticketName.setFont(new Font("SansSerif", Font.BOLD, 13));
        ticketName.setAlignmentX(LEFT_ALIGNMENT);

        JLabel ticketDate = new JLabel("Created on Jan 4, 2026, 12:24 PM");
        ticketDate.setFont(new Font("SansSerif", Font.PLAIN, 11));
        ticketDate.setForeground(new Color(80, 80, 80));
        ticketDate.setAlignmentX(LEFT_ALIGNMENT);

        JPanel content = new JPanel(new BorderLayout(8, 0));
        content.setBackground(new Color(212, 208, 200));
        content.setAlignmentX(LEFT_ALIGNMENT);
        content.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        JPanel leftBtns = new JPanel();
        leftBtns.setLayout(new BoxLayout(leftBtns, BoxLayout.Y_AXIS));
        leftBtns.setBackground(new Color(212, 208, 200));
        leftBtns.add(btn("Ticket Status"));
        leftBtns.add(Box.createVerticalStrut(4));
        leftBtns.add(btn("Add Comment"));
        leftBtns.add(Box.createVerticalStrut(4));
        leftBtns.add(btn("Close Ticket"));
        leftBtns.add(Box.createVerticalStrut(4));
        leftBtns.add(btn("Give Feedback"));

        JTextArea desc = new JTextArea("The problem is...");
        desc.setEditable(false);
        desc.setBackground(Color.WHITE);
        desc.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));

        content.add(leftBtns, BorderLayout.WEST);
        content.add(new JScrollPane(desc), BorderLayout.CENTER);

        JPanel bottomRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        bottomRow.setBackground(new Color(212, 208, 200));
        bottomRow.setAlignmentX(LEFT_ALIGNMENT);
        bottomRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        bottomRow.add(btn("Cancel"));

        p.add(title);
        p.add(Box.createVerticalStrut(2));
        p.add(sub);
        p.add(Box.createVerticalStrut(8));
        p.add(sep);
        p.add(Box.createVerticalStrut(10));
        p.add(ticketName);
        p.add(Box.createVerticalStrut(2));
        p.add(ticketDate);
        p.add(Box.createVerticalStrut(8));
        p.add(content);
        p.add(Box.createVerticalStrut(14));
        p.add(bottomRow);

        add(p);
    }

    private JButton btn(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("SansSerif", Font.PLAIN, 12));
        b.setBackground(new Color(212, 208, 200));
        b.setFocusPainted(false);
        b.setPreferredSize(new Dimension(120, 26));
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OpenedTicketsFrame().setVisible(true));
    }
}

