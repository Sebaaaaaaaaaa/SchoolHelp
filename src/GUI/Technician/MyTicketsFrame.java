package GUI.Technician;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class MyTicketsFrame extends JFrame {

    public MyTicketsFrame() {
        setTitle("School Help - My Tickets");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
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

        String[] cols = {"ID", "Title", "Category", "Priority", "Status"};
        Object[][] data = {
            {"#011", "No internet room 5", "Network",  "High",   "In lavorazione"},
            {"#012", "Keyboard broken",    "Hardware", "Low",    "In attesa"},
            {"#013", "Excel not opening",  "Software", "Medium", "In lavorazione"},
        };
        JTable table = new JTable(new DefaultTableModel(data, cols) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
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
        btns.add(btn("Open Ticket", new Color(0, 120, 215)));
        btns.add(btn("Back", new Color(150, 150, 150)));

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

    private JButton btn(String t, Color bg) { 
        JButton b = new JButton(t); 
        b.setFont(new Font("Segoe UI", Font.BOLD, 14)); 
        b.setBackground(bg); 
        b.setForeground(Color.WHITE); 
        b.setFocusPainted(false); 
        b.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyTicketsFrame().setVisible(true));
    }
}

