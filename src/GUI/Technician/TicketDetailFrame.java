package GUI.Technician;

import java.awt.*;
import javax.swing.*;

public class TicketDetailFrame extends JFrame {

    public TicketDetailFrame() {
        setTitle("School Help – Ticket #011");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(440, 560);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(16, 18, 15, 18));

        p.add(lbl18("Ticket #011"));
        p.add(Box.createVerticalStrut(3));
        p.add(sub("No internet room 5  |  In lavorazione"));
        p.add(Box.createVerticalStrut(10));
        p.add(sep());

        p.add(Box.createVerticalStrut(8));
        p.add(italic("Ticket info"));
        p.add(infoRow("Category:", "Network"));
        p.add(infoRow("Priority:", "High"));
        p.add(infoRow("Opened by:", "Giulia Bianchi"));
        p.add(infoRow("Date:", "15/07/2025 09:32"));
        p.add(Box.createVerticalStrut(6));
        p.add(lbl12("Description"));
        p.add(Box.createVerticalStrut(3));
        JTextArea desc = new JTextArea("The computers in room 5 cannot connect to the internet since this morning.", 3, 0);
        desc.setEditable(false); desc.setLineWrap(true); desc.setWrapStyleWord(true);
        desc.setBackground(new Color(235,235,235));
        JScrollPane ds = new JScrollPane(desc); ds.setAlignmentX(LEFT_ALIGNMENT); ds.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));
        p.add(ds);

        p.add(Box.createVerticalStrut(10));
        p.add(sep());
        p.add(Box.createVerticalStrut(8));
        p.add(italic("Update status"));
        p.add(lbl12("New Status"));
        JComboBox<String> status = new JComboBox<>(new String[]{"In lavorazione","In attesa","Chiuso"});
        status.setBackground(Color.WHITE); status.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28)); status.setAlignmentX(LEFT_ALIGNMENT);
        p.add(status);
        p.add(Box.createVerticalStrut(5));
        p.add(lbl12("Reason (if \"In attesa\")"));
        JTextField reason = new JTextField(); reason.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26)); reason.setAlignmentX(LEFT_ALIGNMENT);
        p.add(reason);

        p.add(Box.createVerticalStrut(10));
        p.add(sep());
        p.add(Box.createVerticalStrut(8));
        p.add(italic("Add public comment (visible to user)"));
        JTextArea pub = new JTextArea(3,0); pub.setLineWrap(true);
        JScrollPane ps = new JScrollPane(pub); ps.setAlignmentX(LEFT_ALIGNMENT); ps.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));
        p.add(ps);

        p.add(Box.createVerticalStrut(8));
        p.add(italic("Add internal note (technicians only)"));
        JTextArea note = new JTextArea(3,0); note.setLineWrap(true); note.setBackground(new Color(255,251,230));
        note.setBorder(BorderFactory.createLineBorder(new Color(200,180,80)));
        JScrollPane ns = new JScrollPane(note); ns.setAlignmentX(LEFT_ALIGNMENT); ns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));
        p.add(ns);

        p.add(Box.createVerticalStrut(12));
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        btns.setBackground(new Color(212,208,200)); btns.setAlignmentX(LEFT_ALIGNMENT); btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        btns.add(btn("Save Changes")); btns.add(btn("Back"));
        p.add(btns);

        p.add(Box.createVerticalStrut(10));
        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("SansSerif", Font.PLAIN, 11)); footer.setForeground(new Color(80,80,80)); footer.setAlignmentX(CENTER_ALIGNMENT);
        p.add(footer);

        JScrollPane outer = new JScrollPane(p); outer.setBorder(null);
        add(outer);
    }

    private JLabel lbl18(String t) { JLabel l = new JLabel(t); l.setFont(new Font("SansSerif",Font.BOLD,18)); l.setAlignmentX(LEFT_ALIGNMENT); return l; }
    private JLabel lbl12(String t) { JLabel l = new JLabel(t); l.setFont(new Font("SansSerif",Font.PLAIN,12)); l.setAlignmentX(LEFT_ALIGNMENT); return l; }
    private JLabel sub(String t)   { JLabel l = new JLabel(t); l.setFont(new Font("SansSerif",Font.PLAIN,11)); l.setForeground(new Color(0,50,160)); l.setAlignmentX(LEFT_ALIGNMENT); return l; }
    private JLabel italic(String t){ JLabel l = new JLabel(t); l.setFont(new Font("SansSerif",Font.ITALIC,11)); l.setForeground(new Color(80,80,80)); l.setAlignmentX(LEFT_ALIGNMENT); return l; }
    private JSeparator sep() { JSeparator s = new JSeparator(); s.setMaximumSize(new Dimension(Integer.MAX_VALUE,2)); s.setAlignmentX(LEFT_ALIGNMENT); return s; }
    private JButton btn(String t) { JButton b = new JButton(t); b.setFont(new Font("SansSerif",Font.PLAIN,12)); b.setBackground(new Color(212,208,200)); b.setFocusPainted(false); return b; }
    private JPanel infoRow(String lbl, String val) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT,4,1));
        row.setBackground(new Color(212,208,200)); row.setAlignmentX(LEFT_ALIGNMENT); row.setMaximumSize(new Dimension(Integer.MAX_VALUE,22));
        JLabel l = new JLabel(lbl); l.setFont(new Font("SansSerif",Font.PLAIN,12)); l.setForeground(new Color(80,80,80)); l.setPreferredSize(new Dimension(90,18));
        JLabel v = new JLabel(val); v.setFont(new Font("SansSerif",Font.BOLD,12));
        row.add(l); row.add(v); return row;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketDetailFrame().setVisible(true));
    }
}

