package GUI.Technician;

import ApplicationServices.TicketService;
import DataModels.FeedbackModel;

import java.awt.*;
import javax.swing.*;

public class TicketDetailDialog extends JDialog {

    public TicketDetailDialog(Frame owner, String ticketId) {
        super(owner, "School Help - Ticket " + ticketId, true);

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(520, 720);
        setLocationRelativeTo(owner);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        p.add(lbl("Ticket #011", 28, new Color(40, 40, 40)));
        p.add(Box.createVerticalStrut(5));
        p.add(lbl("No internet room 5  |  In lavorazione", 14, new Color(0, 120, 215)));
        p.add(Box.createVerticalStrut(15));
        p.add(sep());

        p.add(Box.createVerticalStrut(15));
        p.add(italic("Ticket info"));
        p.add(Box.createVerticalStrut(5));
        p.add(infoRow("Category:", "Network"));
        p.add(infoRow("Priority:", "High"));
        p.add(infoRow("Opened by:", "Giulia Bianchi"));
        p.add(infoRow("Date:", "15/07/2025 09:32"));
        p.add(Box.createVerticalStrut(15));
        p.add(lbl("Description", 12, new Color(80, 80, 80)));
        p.add(Box.createVerticalStrut(5));

        JTextArea desc = new JTextArea(
                "The computers in room 5 cannot connect to the internet since this morning.",
                3, 0
        );
        desc.setEditable(false);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        desc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        desc.setBackground(new Color(245, 245, 245));
        desc.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JScrollPane ds = new JScrollPane(desc);
        ds.setAlignmentX(LEFT_ALIGNMENT);
        ds.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        ds.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        p.add(ds);

        p.add(Box.createVerticalStrut(20));
        p.add(sep());
        p.add(Box.createVerticalStrut(15));
        p.add(italic("Update status"));
        p.add(Box.createVerticalStrut(5));
        p.add(lbl("New Status", 12, new Color(80, 80, 80)));
        p.add(Box.createVerticalStrut(5));

        JComboBox<String> status =
                new JComboBox<>(new String[]{"In lavorazione", "In attesa", "Chiuso"});
        status.setBackground(Color.WHITE);
        status.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        status.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        status.setAlignmentX(LEFT_ALIGNMENT);
        p.add(status);

        p.add(Box.createVerticalStrut(10));
        p.add(lbl("Reason (if \"In attesa\")", 12, new Color(80, 80, 80)));
        p.add(Box.createVerticalStrut(5));

        JTextField reason = new JTextField();
        reason.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        reason.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        reason.setAlignmentX(LEFT_ALIGNMENT);
        reason.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        p.add(reason);

        p.add(Box.createVerticalStrut(20));
        p.add(sep());
        p.add(Box.createVerticalStrut(15));
        p.add(italic("Add public comment (visible to user)"));
        p.add(Box.createVerticalStrut(5));

        JTextArea pub = new JTextArea(3, 0);
        pub.setLineWrap(true);
        pub.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pub.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane ps = new JScrollPane(pub);
        ps.setAlignmentX(LEFT_ALIGNMENT);
        ps.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        ps.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        p.add(ps);

        p.add(Box.createVerticalStrut(15));
        p.add(italic("Add internal note (technicians only)"));
        p.add(Box.createVerticalStrut(5));

        JTextArea note = new JTextArea(3, 0);
        note.setLineWrap(true);
        note.setBackground(new Color(255, 250, 240));
        note.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        note.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane ns = new JScrollPane(note);
        ns.setAlignmentX(LEFT_ALIGNMENT);
        ns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        ns.setBorder(BorderFactory.createLineBorder(new Color(220, 200, 100)));
        p.add(ns);

        p.add(Box.createVerticalStrut(20));

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btns.setBackground(Color.WHITE);
        btns.setAlignmentX(LEFT_ALIGNMENT);
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btns.add(btn("Save Changes", new Color(0, 120, 215)));
        btns.add(btn("Back", new Color(150, 150, 150)));
        p.add(btns);

        p.add(Box.createVerticalStrut(20));
        p.add(sep());
        p.add(Box.createVerticalStrut(15));
        p.add(italic("User feedback"));
        p.add(Box.createVerticalStrut(8));

        FeedbackModel fb = TicketService.getFeedbackForTicket(ticketId);

        if (fb == null) {
            JLabel noFb = new JLabel("No feedback submitted yet.");
            noFb.setFont(new Font("Segoe UI", Font.ITALIC, 13));
            noFb.setForeground(new Color(160, 160, 160));
            noFb.setAlignmentX(LEFT_ALIGNMENT);
            p.add(noFb);
        } else {
            p.add(infoRow("Rating:", fb.getRating() + " / 5 ★"));
            p.add(Box.createVerticalStrut(8));

            p.add(lbl("Written review", 12, new Color(80, 80, 80)));
            p.add(Box.createVerticalStrut(4));

            JTextArea reviewArea = new JTextArea(fb.getReview(), 3, 0);
            reviewArea.setEditable(false);
            reviewArea.setLineWrap(true);
            reviewArea.setWrapStyleWord(true);
            reviewArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            reviewArea.setBackground(new Color(245, 245, 245));
            reviewArea.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

            JScrollPane rs = new JScrollPane(reviewArea);
            rs.setAlignmentX(LEFT_ALIGNMENT);
            rs.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
            rs.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
            p.add(rs);
        }

        p.add(Box.createVerticalStrut(20));

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(new Color(150, 150, 150));
        footer.setAlignmentX(CENTER_ALIGNMENT);
        p.add(footer);

        JScrollPane outer = new JScrollPane(p);
        outer.setBorder(null);
        outer.getVerticalScrollBar().setUnitIncrement(16);

        add(outer);
    }

    private JLabel lbl(String t, int size, Color c) {
        JLabel l = new JLabel(t);
        l.setFont(new Font("Segoe UI", Font.BOLD, size));
        l.setForeground(c);
        l.setAlignmentX(LEFT_ALIGNMENT);
        return l;
    }

    private JLabel italic(String t) {
        JLabel l = new JLabel(t);
        l.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        l.setForeground(new Color(120, 120, 120));
        l.setAlignmentX(LEFT_ALIGNMENT);
        return l;
    }

    private JSeparator sep() {
        JSeparator s = new JSeparator();
        s.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        s.setAlignmentX(LEFT_ALIGNMENT);
        s.setForeground(new Color(230, 230, 230));
        return s;
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

    private JPanel infoRow(String lbl, String val) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 2));
        row.setBackground(Color.WHITE);
        row.setAlignmentX(LEFT_ALIGNMENT);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));

        JLabel l = new JLabel(lbl);
        l.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        l.setForeground(new Color(80, 80, 80));
        l.setPreferredSize(new Dimension(90, 20));

        JLabel v = new JLabel(val);
        v.setFont(new Font("Segoe UI", Font.BOLD, 14));
        v.setForeground(new Color(40, 40, 40));

        row.add(l);
        row.add(v);
        return row;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicketDetailDialog dialog =
                    new TicketDetailDialog(null, "test-ticket-id");
            dialog.setVisible(true);
        });
    }
}