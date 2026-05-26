package GUI.Admin;

import java.awt.*;
import javax.swing.*;

public class StatisticsOverviewFrame extends JFrame {

    public StatisticsOverviewFrame() {
        setTitle("School Help - Statistics Overview");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(460, 320);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Statistics Overview");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);
        JLabel sub = new JLabel("View the statistics of the application");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JPanel grid = new JPanel(new GridLayout(2, 3, 15, 15));
        grid.setBackground(Color.WHITE);
        grid.setAlignmentX(LEFT_ALIGNMENT);
        grid.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        grid.add(statBlock("Active Tickets",  "2"));
        grid.add(statBlock("Closed Tickets",  "1"));
        grid.add(statBlock("On-Hold Tickets", "0"));
        grid.add(statBlock("Students",        "34"));
        grid.add(statBlock("Operators",       "3"));
        grid.add(statBlock("Administrators",  "2"));

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        btns.setBackground(Color.WHITE); 
        btns.setAlignmentX(LEFT_ALIGNMENT); 
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        JButton cancel = new JButton("Cancel"); 
        cancel.setFont(new Font("Segoe UI", Font.BOLD, 14)); 
        cancel.setBackground(new Color(150, 150, 150)); 
        cancel.setForeground(Color.WHITE);
        cancel.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        cancel.setFocusPainted(false);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btns.add(cancel);

        p.add(title); 
        p.add(Box.createVerticalStrut(5)); 
        p.add(sub);
        p.add(Box.createVerticalStrut(25)); 
        p.add(grid);
        p.add(Box.createVerticalStrut(20)); 
        p.add(btns);
        add(p);
    }

    private JPanel statBlock(String label, String value) {
        JPanel b = new JPanel(); 
        b.setLayout(new BoxLayout(b, BoxLayout.Y_AXIS)); 
        b.setBackground(Color.WHITE);
        JLabel l = new JLabel(label); 
        l.setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        l.setForeground(new Color(80, 80, 80));
        l.setAlignmentX(LEFT_ALIGNMENT);
        JTextField f = new JTextField(value); 
        f.setEditable(false); 
        f.setBackground(new Color(245, 245, 245)); 
        f.setFont(new Font("Segoe UI", Font.BOLD, 16));
        f.setForeground(new Color(40, 40, 40));
        f.setMaximumSize(new Dimension(100, 36)); 
        f.setAlignmentX(LEFT_ALIGNMENT);
        f.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        b.add(l); 
        b.add(Box.createVerticalStrut(5)); 
        b.add(f); 
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StatisticsOverviewFrame().setVisible(true));
    }
}

