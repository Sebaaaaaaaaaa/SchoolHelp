package GUI.Admin;

import java.awt.*;
import javax.swing.*;

public class TicketsOverviewFrame extends JFrame {

    public TicketsOverviewFrame() {
        setTitle("School Help - Tickets Overview");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Ticket #001, Status: Closed");
        model.addElement("Ticket #002, Status: On-Hold");
        model.addElement("Ticket #003, Status: Active");
        JList<String> list = new JList<>(model);
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
        JComboBox<String> statusC = new JComboBox<>(new String[]{"Active","On-Hold","Closed"}); 
        statusC.setSelectedItem("On-Hold"); 
        statusC.setBackground(Color.WHITE);
        statusC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JTextArea descA = new JTextArea(4,0); 
        descA.setLineWrap(true);
        descA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane descScroll = new JScrollPane(descA);
        descScroll.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        JTextField op = tf();
        JComboBox<String> prioC = new JComboBox<>(new String[]{"High","Medium","Low","Critical"}); 
        prioC.setBackground(Color.WHITE);
        prioC.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        g.gridx=0; g.gridy=0; fields.add(lbl("Utente"),g);        g.gridx=2; fields.add(lbl("Ticket Status"),g);
        g.gridx=0; g.gridy=1; fields.add(utente,g);               g.gridx=2; fields.add(statusC,g);
        g.gridx=0; g.gridy=2; fields.add(lbl("Description"),g);   g.gridx=2; fields.add(lbl("Operator"),g);
        g.gridx=0; g.gridy=3; g.gridheight=2; fields.add(descScroll,g); g.gridheight=1;
        g.gridx=2; g.gridy=3; fields.add(op,g);
        g.gridx=0; g.gridy=5; fields.add(lbl("Priority"),g);
        g.gridx=0; g.gridy=6; fields.add(prioC,g);

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
        return b; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketsOverviewFrame().setVisible(true));
    }
}
