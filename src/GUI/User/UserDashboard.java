package GUI.User;

import ApplicationServices.TicketService;
import DataModels.AccountModel;
import java.awt.*;
import javax.swing.*;

public class UserDashboard extends JFrame {

    private final JFrame owner;
    private final TicketService ticketService;
    private final AccountModel account;
    
    public UserDashboard(JFrame owner, TicketService ticketService, AccountModel account) {
        
        this.owner = owner;
        this.ticketService = ticketService;
        this.account = account;
        
        setTitle("School Help - User Dashboard");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                owner.setVisible(true);
                dispose();
            }
        });
        setSize(320, 320);
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

        JLabel sub = new JLabel("Create and manage your tickets");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(CENTER_ALIGNMENT);

        JButton btnCreate = btn("Create New Ticket");
        btnCreate.addActionListener(e -> 
                new CreateNewTicketDialog(this, ticketService, account).setVisible(true)
        );

        JButton btnView = btn("View Opened Tickets");
        btnView.addActionListener(e -> 
                new OpenedTicketsDialog(this, ticketService, account).setVisible(true)
        );

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(new Color(150, 150, 150));
        footer.setAlignmentX(CENTER_ALIGNMENT);

        p.add(title);
        p.add(Box.createVerticalStrut(5));
        p.add(sub);
        p.add(Box.createVerticalStrut(25));
        p.add(btnCreate);
        p.add(Box.createVerticalStrut(10));
        p.add(btnView);
        p.add(Box.createVerticalStrut(25));
        p.add(footer);

        add(p);
    }

    private JButton btn(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(new Color(0, 120, 215));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        b.setAlignmentX(CENTER_ALIGNMENT);
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserDashboard(null, null, null).setVisible(true));
    }
}
