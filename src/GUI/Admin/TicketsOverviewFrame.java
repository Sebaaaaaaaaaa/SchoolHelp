package GUI.Admin;

import java.awt.*;
import javax.swing.*;

public class TicketsOverviewFrame extends JFrame {

    public TicketsOverviewFrame() {
        setTitle("School Help – Tickets Overview");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(490, 440);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel title = new JLabel("Tickets Overview");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);
        JLabel sub = new JLabel("Choose a ticket and overview its current situation or change it");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        sub.setForeground(new Color(60,60,60));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Ticket #001, Status: Closed");
        model.addElement("Ticket #002, Status: On-Hold");
        model.addElement("Ticket #003, Status: Active");
        JList<String> list = new JList<>(model);
        list.setFont(new Font("SansSerif", Font.PLAIN, 12));
        list.setBackground(Color.WHITE);
        JScrollPane listScroll = new JScrollPane(list);
        listScroll.setAlignmentX(LEFT_ALIGNMENT);
        listScroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        listScroll.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));

        JPanel fields = new JPanel(new GridBagLayout());
        fields.setBackground(new Color(212,208,200));
        fields.setAlignmentX(LEFT_ALIGNMENT);
        fields.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4,2,4,8); g.fill = GridBagConstraints.HORIZONTAL; g.anchor = GridBagConstraints.WEST; g.weightx = 0.5;

        JTextField utente = tf(); JComboBox<String> statusC = new JComboBox<>(new String[]{"Active","On-Hold","Closed"}); statusC.setSelectedItem("On-Hold"); statusC.setBackground(Color.WHITE);
        JTextArea descA = new JTextArea(4,0); descA.setLineWrap(true);
        JTextField op = tf();
        JComboBox<String> prioC = new JComboBox<>(new String[]{"High","Medium","Low","Critical"}); prioC.setBackground(Color.WHITE);

        g.gridx=0; g.gridy=0; fields.add(lbl("Utente"),g);        g.gridx=2; fields.add(lbl("Ticket Status"),g);
        g.gridx=0; g.gridy=1; fields.add(utente,g);               g.gridx=2; fields.add(statusC,g);
        g.gridx=0; g.gridy=2; fields.add(lbl("Description"),g);   g.gridx=2; fields.add(lbl("Operator"),g);
        g.gridx=0; g.gridy=3; g.gridheight=2; fields.add(new JScrollPane(descA),g); g.gridheight=1;
        g.gridx=2; g.gridy=3; fields.add(op,g);
        g.gridx=0; g.gridy=5; fields.add(lbl("Priority"),g);
        g.gridx=0; g.gridy=6; fields.add(prioC,g);

        JPanel btnRow = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,0));
        btnRow.setBackground(new Color(212,208,200)); btnRow.setAlignmentX(LEFT_ALIGNMENT); btnRow.setMaximumSize(new Dimension(Integer.MAX_VALUE,36));
        btnRow.add(btn("Cancel"));

        p.add(title); p.add(Box.createVerticalStrut(2)); p.add(sub); p.add(Box.createVerticalStrut(10));
        p.add(listScroll); p.add(Box.createVerticalStrut(10)); p.add(fields); p.add(Box.createVerticalStrut(8)); p.add(btnRow);
        add(p);
    }

    private JLabel lbl(String t) { JLabel l = new JLabel(t); l.setFont(new Font("SansSerif",Font.PLAIN,12)); return l; }
    private JTextField tf() { JTextField f = new JTextField(); f.setFont(new Font("SansSerif",Font.PLAIN,12)); return f; }
    private JButton btn(String t) { JButton b = new JButton(t); b.setFont(new Font("SansSerif",Font.PLAIN,12)); b.setBackground(new Color(212,208,200)); b.setFocusPainted(false); return b; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketsOverviewFrame().setVisible(true));
    }
}
