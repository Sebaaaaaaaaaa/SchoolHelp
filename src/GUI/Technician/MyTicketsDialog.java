package GUI.Technician;

import ApplicationServices.TicketService;
import DataModels.AccountModel;
import DataModels.TechnicianTicketsTableModel;
import DataModels.TicketModel;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class MyTicketsDialog extends JDialog {

    private Frame owner;
    private JTable table;
    
    public MyTicketsDialog(Frame owner, TicketService ticketService, AccountModel account) {
        super(owner, "School Help - My Tickets", true);
        
        this.owner = owner;
        
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(owner);
        setResizable(false);

        JPanel p = new JPanel(new BorderLayout(0, 15));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(Color.WHITE);

        JLabel title = new JLabel("My Tickets");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel("Tickets currently assigned to you");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(sub);

        table = new JTable(new TechnicianTicketsTableModel(ticketService.getTechnicianTickets(account.getAccountId())));

        table.setRowHeight(30);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setForeground(new Color(60, 60, 60));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(245, 245, 245));
        table.getTableHeader().setForeground(new Color(40, 40, 40));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        scroll.getViewport().setBackground(Color.WHITE);

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btns.setBackground(Color.WHITE);
        btns.add(btn("Open Ticket", new Color(0, 120, 215), table));
        btns.add(btn("Back", new Color(150, 150, 150), null));

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(new Color(150, 150, 150));
        footer.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(Color.WHITE);
        bottom.add(btns, BorderLayout.WEST);
        bottom.add(footer, BorderLayout.SOUTH);

        p.add(header, BorderLayout.NORTH);
        p.add(scroll, BorderLayout.CENTER);
        p.add(bottom, BorderLayout.SOUTH);

        add(p);
    }

    private JButton btn(String t, Color bg, JTable table) {
        JButton b = new JButton(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        if (t.equals("Open Ticket")) {
            b.addActionListener(e -> {
                int row = table.getSelectedRow();

                if (row != -1) {
                    TicketModel ticket = ((TechnicianTicketsTableModel) table.getModel()).getTicketAt(row);
                    new TicketDetailDialog(this, ticket).setVisible(true);
                    ((TechnicianTicketsTableModel) table.getModel()).refresh();
                } else {
                    JOptionPane.showMessageDialog(this, "Select a Ticket", "Selection Failed",
                        JOptionPane.ERROR_MESSAGE);
                }
            });
        } else {
            b.addActionListener(e -> {
                owner.setVisible(true);
                dispose();
            });
        }
        
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyTicketsDialog dialog = new MyTicketsDialog(null, null, null);
            dialog.setVisible(true);
        });
    }
}