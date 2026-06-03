package GUI.Technician;

import DataModels.TicketModel;
import java.awt.*;
import javax.swing.*;

public class CloseTicketDialog extends JDialog {
    
    private TicketModel ticket;

    public CloseTicketDialog(JDialog owner, TicketModel ticket) {
        super(owner, "School Help - Close Ticket", true);
        
        this.ticket = ticket;

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(400, 320);
        setLocationRelativeTo(owner);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Close Ticket #011");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel("Fill in the solution before closing");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JLabel solLbl = new JLabel("Solution adopted");
        solLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        solLbl.setForeground(new Color(80, 80, 80));
        solLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea area = new JTextArea(5, 0);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
            )
        );
        scroll.setAlignmentX(LEFT_ALIGNMENT);
        scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btns.setBackground(Color.WHITE);
        btns.setAlignmentX(LEFT_ALIGNMENT);
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        btns.add(btn("Close Ticket", new Color(0, 120, 215), area.getText()));

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(new Color(150, 150, 150));
        footer.setAlignmentX(CENTER_ALIGNMENT);

        p.add(title);
        p.add(Box.createVerticalStrut(5));
        p.add(sub);
        p.add(Box.createVerticalStrut(20));
        p.add(solLbl);
        p.add(Box.createVerticalStrut(5));
        p.add(scroll);
        p.add(Box.createVerticalStrut(20));
        p.add(btns);
        p.add(Box.createVerticalStrut(15));
        p.add(footer);

        add(p);
    }

    private JButton btn(String t, Color bg, String closingReason) {
        JButton b = new JButton(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.addActionListener(e -> {
            ticket.setClosingReason(closingReason);
            
            JOptionPane.showMessageDialog(this,
                "Closed successfully!",
                "Success", JOptionPane.INFORMATION_MESSAGE);
            
            dispose();
        });
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CloseTicketDialog dialog = new CloseTicketDialog(null, null);
            dialog.setVisible(true);
        });
    }
}