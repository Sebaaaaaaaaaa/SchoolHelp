package GUI.Admin;

import ApplicationServices.TicketService;
import DataModels.TicketModel;
import DataModels.TicketsOverviewListModel;
import Utils.PriorityLevels;
import Utils.TicketStates;
import java.awt.*;
import javax.swing.*;

public class TicketsOverviewDialog extends JDialog {
    
    private final JFrame owner;
    private TicketModel selectedTicket;

    public TicketsOverviewDialog(JFrame owner, TicketService ticketService) {
        super(owner, "School Help - Tickets Overview", true);
        
        this.owner = owner;
        this.selectedTicket = null;
        
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(550, 560);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Tickets Overview");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);
        JLabel sub = new JLabel("Choose a ticket and overview its current situation or change it");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JList<String> list = new JList<>(new TicketsOverviewListModel(ticketService.getTickets()));
        list.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        list.setBackground(Color.WHITE);
        list.setForeground(new Color(60, 60, 60));
        JScrollPane listScroll = new JScrollPane(list);
        listScroll.setAlignmentX(LEFT_ALIGNMENT);
        listScroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        listScroll.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        JPanel fields = new JPanel(new GridBagLayout());
        fields.setBackground(Color.WHITE);
        fields.setAlignmentX(LEFT_ALIGNMENT);
        fields.setMaximumSize(new Dimension(Integer.MAX_VALUE, 240));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 4, 6, 12); 
        g.fill = GridBagConstraints.HORIZONTAL; 
        g.anchor = GridBagConstraints.WEST; 
        g.weightx = 0.5;

        JTextField utente = tf(); 
        
        JComboBox<TicketStates> statusC = new JComboBox<>(TicketStates.values());
        statusC.setEnabled(false);
        statusC.addActionListener(e -> {
            selectedTicket.setState((TicketStates) statusC.getSelectedItem());
            list.setModel(new TicketsOverviewListModel(ticketService.getTickets()));
        });
        statusC.setBackground(Color.WHITE);
        statusC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JTextField op = tf();
        
        JComboBox<PriorityLevels> prioC = new JComboBox<>(PriorityLevels.values());
        prioC.setEnabled(false);
        prioC.addActionListener(e -> {
            selectedTicket.setPriority((PriorityLevels) prioC.getSelectedItem());
            list.setModel(new TicketsOverviewListModel(ticketService.getTickets()));
        });
        prioC.setBackground(Color.WHITE);
        prioC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = list.getSelectedIndex();
                
                if (row > -1) {
                    selectedTicket = ((TicketsOverviewListModel) list.getModel()).getTicketAt(row);

                    utente.setText(selectedTicket.getUserAccount().getFullName());
                    op.setText((selectedTicket.getTechnicianAccount() != null? selectedTicket.getTechnicianAccount().getFullName(): "None"));

                    statusC.setEnabled(true);
                    statusC.setSelectedItem(selectedTicket.getState());
                    prioC.setEnabled(true);
                    prioC.setSelectedItem(selectedTicket.getPriority());   
                }
            }
        });

        g.gridx = 0; g.gridy = 0;
        fields.add(lbl("Utente"), g);

        g.gridx = 2; g.gridy = 0;
        fields.add(lbl("Ticket Status"), g);

        g.gridx = 0; g.gridy = 1;
        fields.add(utente, g);

        g.gridx = 2; g.gridy = 1;
        fields.add(statusC, g);

        g.gridx = 0; g.gridy = 2;
        fields.add(lbl("Operator"), g);

        g.gridx = 0; g.gridy = 3;
        fields.add(op, g);

        g.gridx = 2; g.gridy = 2;
        fields.add(lbl("Priority"), g);

        g.gridx = 2; g.gridy = 3;
        fields.add(prioC, g);

        JPanel btnRow = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        btnRow.setBackground(Color.WHITE); 
        btnRow.setAlignmentX(LEFT_ALIGNMENT); 
        btnRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnRow.add(btn("Cancel", new Color(150, 150, 150)));

        p.add(title); 
        p.add(Box.createVerticalStrut(5)); 
        p.add(sub); 
        p.add(Box.createVerticalStrut(20));
        p.add(listScroll); 
        p.add(Box.createVerticalStrut(20)); 
        p.add(fields); 
        p.add(Box.createVerticalStrut(15)); 
        p.add(btnRow);
        add(p);
    }

    private JLabel lbl(String t) { 
        JLabel l = new JLabel(t); 
        l.setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        l.setForeground(new Color(80, 80, 80));
        return l; 
    }
    
    private JTextField tf() { 
        JTextField f = new JTextField(); 
        f.setEditable(false);
        f.setFont(new Font("Segoe UI", Font.PLAIN, 14)); 
        f.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        return f; 
    }
    
    private JButton btn(String t, Color bg) { 
        JButton b = new JButton(t); 
        b.setFont(new Font("Segoe UI", Font.BOLD, 14)); 
        b.setBackground(bg); 
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false); 
        b.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.addActionListener(e -> {
            owner.setVisible(true);
            dispose();
        });
        return b; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketsOverviewDialog(null, null).setVisible(true));
    }
}
