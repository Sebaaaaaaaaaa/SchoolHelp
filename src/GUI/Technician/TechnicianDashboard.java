package GUI.Technician;

import ApplicationServices.TicketService;
import DataModels.AccountModel;
import java.awt.*;
import javax.swing.*;

public class TechnicianDashboard extends JFrame {
    
    private final Frame owner;
    private final TicketService ticketService;
    private final AccountModel account;

    public TechnicianDashboard(Frame owner, TicketService ticketService, AccountModel account) {
        
        this.owner = owner;
        this.ticketService = ticketService;
        this.account = account;
        
        
        setTitle("School Help - Technician Panel");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
            b.setBackground(new Color(200, 50, 50));
            b.addActionListener(e -> {
                owner.setVisible(true);
                dispose();
            });
        } else if (t.equals("View My Tickets")) {
            b.addActionListener(e -> {
                this.setVisible(false);
                new MyTicketsDialog(this, ticketService, account).setVisible(true);
            });
        } else {
            b.addActionListener(e -> {
                this.setVisible(false);
                new UnassignedTicketsDialog(this, ticketService, account).setVisible(true);
            });
        }

        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TechnicianDashboard(null, null, null).setVisible(true));
    }
}
