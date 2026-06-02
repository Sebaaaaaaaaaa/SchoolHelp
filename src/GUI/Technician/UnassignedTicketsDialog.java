package GUI.Technician;

import ApplicationServices.TicketService;
import DataModels.AccountModel;
import DataModels.TechnicianTicketsTableModel;
import DataModels.TicketModel;
import DataModels.UnassignedTicketsTableModel;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class UnassignedTicketsDialog extends JDialog {
    
    private final JFrame owner;
    private final AccountModel account;

    public UnassignedTicketsDialog(JFrame owner, TicketService ticketService, AccountModel account) {
        super(owner, "School Help - Unassigned Tickets", true);
        
        this.owner = owner;
        this.account = account;

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(owner);
        setResizable(false);

        JPanel p = new JPanel(new BorderLayout(0, 15));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(Color.WHITE);

        JLabel title = new JLabel("Unassigned Tickets");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel(
                "Select a ticket and click \"Take Charge\" to assign it to yourself"
        );
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(sub);

        JTable table = new JTable(new UnassignedTicketsTableModel(ticketService.getUnassignedTickets()));

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
        btns.add(btn("Take Charge", new Color(0, 120, 215), table));
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
        
        if (t.equals("Take Charge")) {
            b.addActionListener(e -> {
                int row = table.getSelectedRow();

                if (row != -1) {
                    TicketModel ticket = ((UnassignedTicketsTableModel) table.getModel()).getTicketAt(row);
                    ticket.setTechnician(account);
                    int modelRow = table.convertRowIndexToModel(row);
                    ((UnassignedTicketsTableModel) table.getModel()).removeTicketAt(modelRow);
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
            UnassignedTicketsDialog dialog = new UnassignedTicketsDialog(null, null, null);
            dialog.setVisible(true);
        });
    }
}