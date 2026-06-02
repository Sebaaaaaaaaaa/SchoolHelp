package GUI.Admin;

import ApplicationServices.AdministrationService;
import ApplicationServices.TicketService;
import DataModels.AccountModel;
import GUI.Technician.MyTicketsDialog;
import GUI.Technician.UnassignedTicketsDialog;
import java.awt.*;
import javax.swing.*;

public class AdminDashboard extends JFrame {

    private final JFrame owner;
    private final TicketService ticketService;
    private final AdministrationService adminServices;
    private final AccountModel account;
    
    public AdminDashboard(JFrame owner, TicketService ticketService, AdministrationService adminServices, AccountModel account) {
        
        this.owner = owner;
        this.ticketService = ticketService;
        this.adminServices = adminServices;
        this.account = account;
        
        setTitle("School Help - Admin Dashboard");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                owner.setVisible(true);
                dispose();
            }
        });
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

        JLabel sub = new JLabel("Manage and view application data");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(CENTER_ALIGNMENT);

        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        sep.setForeground(new Color(230, 230, 230));

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(new Color(150, 150, 150));
        footer.setAlignmentX(CENTER_ALIGNMENT);

        p.add(title);
        p.add(Box.createVerticalStrut(5));
        p.add(sub);
        p.add(Box.createVerticalStrut(25));
        p.add(btn("Ticket Overview"));
        p.add(Box.createVerticalStrut(10));
        p.add(btn("Manage Users"));
        p.add(Box.createVerticalStrut(10));
        p.add(btn("View Statistics"));
        p.add(Box.createVerticalStrut(20));
        p.add(sep);
        p.add(Box.createVerticalStrut(10));
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
        
        if (t.equals("Ticket Overview")) {
            b.addActionListener(e -> {
                new TicketsOverviewDialog(this, ticketService).setVisible(true);
            });
        } else if (t.equals("Manage Users")) {
            b.addActionListener(e -> {
                new ManageUsersDialog(this, adminServices, account).setVisible(true);
            });
        } else {
            b.addActionListener(e -> {
                new StatisticsOverviewDialog(this, adminServices, ticketService).setVisible(true);
            });
        }
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminDashboard(null, null, null, null).setVisible(true));
    }
}
