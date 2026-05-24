package GUI.Technician;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class UnassignedTicketsFrame extends JFrame {

    public UnassignedTicketsFrame() {
        setTitle("School Help – Unassigned Tickets");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(580, 340);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel(new BorderLayout(0, 10));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(16, 18, 15, 18));

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(new Color(212, 208, 200));
        JLabel title = new JLabel("Unassigned Tickets");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);
        JLabel sub = new JLabel("Select a ticket and click \"Take Charge\" to assign it to yourself");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        sub.setForeground(new Color(60,60,60));
        sub.setAlignmentX(LEFT_ALIGNMENT);
        header.add(title);
        header.add(Box.createVerticalStrut(3));
        header.add(sub);

        String[] cols = {"ID", "Title", "Category", "Priority", "Date"};
        Object[][] data = {                                                                  
            {"#014", "Printer offline lab B", "Network",  "High",     "15/07/2025"},
            {"#015", "PC won't start room 3", "Hardware", "Critical", "15/07/2025"},
            {"#016", "Install Scratch 3.0",   "Software", "Low",      "14/07/2025"},
            {"#017", "Projector not working", "Hardware", "High",     "14/07/2025"},
            {"#018", "Network slow room 12",  "Network",  "Medium",   "13/07/2025"},
        };
        JTable table = new JTable(new DefaultTableModel(data, cols) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
        table.setRowHeight(22);
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        btns.setBackground(new Color(212, 208, 200));
        btns.add(btn("Take Charge"));
        btns.add(btn("Back"));

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("SansSerif", Font.PLAIN, 11));
        footer.setForeground(new Color(80,80,80));
        footer.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(new Color(212, 208, 200));
        bottom.add(btns, BorderLayout.WEST);
        bottom.add(footer, BorderLayout.SOUTH);

        p.add(header, BorderLayout.NORTH);
        p.add(scroll, BorderLayout.CENTER);
        p.add(bottom, BorderLayout.SOUTH);
        add(p);
    }

    private JButton btn(String t) { JButton b = new JButton(t); b.setFont(new Font("SansSerif", Font.PLAIN, 12)); b.setBackground(new Color(212, 208, 200)); b.setFocusPainted(false); return b; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnassignedTicketsFrame().setVisible(true));
    }
}

