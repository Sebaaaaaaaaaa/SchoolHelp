package GUI.Admin;

import java.awt.*;
import javax.swing.*;

public class StatisticsOverviewFrame extends JFrame {

    public StatisticsOverviewFrame() {
        setTitle("School Help – Statistics");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(370, 250);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel title = new JLabel("Statistics Overview");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);
        JLabel sub = new JLabel("View the statistics of the application");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        sub.setForeground(new Color(60,60,60));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JPanel grid = new JPanel(new GridLayout(2, 3, 12, 10));
        grid.setBackground(new Color(212,208,200));
        grid.setAlignmentX(LEFT_ALIGNMENT);
        grid.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));
        grid.add(statBlock("Active Tickets",  "2"));
        grid.add(statBlock("Closed Tickets",  "1"));
        grid.add(statBlock("On-Hold Tickets", "0"));
        grid.add(statBlock("Students",        "34"));
        grid.add(statBlock("Operators",       "3"));
        grid.add(statBlock("Administrators",  "2"));

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,0));
        btns.setBackground(new Color(212,208,200)); btns.setAlignmentX(LEFT_ALIGNMENT); btns.setMaximumSize(new Dimension(Integer.MAX_VALUE,36));
        JButton cancel = new JButton("Cancel"); cancel.setFont(new Font("SansSerif",Font.PLAIN,12)); cancel.setBackground(new Color(212,208,200)); cancel.setFocusPainted(false);
        btns.add(cancel);

        p.add(title); p.add(Box.createVerticalStrut(2)); p.add(sub);
        p.add(Box.createVerticalStrut(16)); p.add(grid);
        p.add(Box.createVerticalStrut(12)); p.add(btns);
        add(p);
    }

    private JPanel statBlock(String label, String value) {
        JPanel b = new JPanel(); b.setLayout(new BoxLayout(b, BoxLayout.Y_AXIS)); b.setBackground(new Color(212,208,200));
        JLabel l = new JLabel(label); l.setFont(new Font("SansSerif",Font.PLAIN,11)); l.setAlignmentX(LEFT_ALIGNMENT);
        JTextField f = new JTextField(value); f.setEditable(false); f.setBackground(Color.WHITE); f.setMaximumSize(new Dimension(100,26)); f.setAlignmentX(LEFT_ALIGNMENT);
        b.add(l); b.add(Box.createVerticalStrut(2)); b.add(f); return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StatisticsOverviewFrame().setVisible(true));
    }
}

