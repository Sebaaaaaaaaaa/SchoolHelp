package GUI.Technician;

import DataModels.AccountModel;
import DataModels.FeedbackModel;
import DataModels.InternalNoteModel;
import DataModels.TicketModel;
import GUI.ChatDialog;
import Utils.PriorityLevels;
import Utils.TicketStates;

import java.awt.*;
import javax.swing.*;

public class TicketDetailDialog extends JDialog {
    
    private final JDialog owner;
    private final TicketModel selectedTicket;
    private final JComboBox<TicketStates> status;
    private final AccountModel account;
    private JTextArea note;

    public TicketDetailDialog(JDialog owner, TicketModel selectedTicket, AccountModel account) {
        super(owner, "School Help - Ticket " + selectedTicket.getTicketId(), true);
        
        this.owner = owner;
        this.account = account;
        this.selectedTicket = selectedTicket;
        
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(520, 720);
        setLocationRelativeTo(owner);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        p.add(lbl("Ticket #" + selectedTicket.getTicketId(), 28, new Color(40, 40, 40)));
        p.add(Box.createVerticalStrut(5));
        p.add(lbl(selectedTicket.getTitle() + " | " + selectedTicket.getState().getState(), 14, new Color(0, 120, 215)));
        p.add(Box.createVerticalStrut(15));
        p.add(sep());

        p.add(Box.createVerticalStrut(15));
        p.add(italic("Ticket info"));
        p.add(Box.createVerticalStrut(4));
        p.add(infoRow("Priority:", selectedTicket.getPriority().getLevel()));
        p.add(infoRow("Opened by:", selectedTicket.getUserAccount().getFullName()));
        p.add(infoRow("Date:", selectedTicket.getCreatedAt()));
        p.add(Box.createVerticalStrut(15));
        p.add(lbl("Description", 12, new Color(80, 80, 80)));
        p.add(Box.createVerticalStrut(5));

        JTextArea desc = new JTextArea(
                selectedTicket.getDescription(),
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
        p.add(Box.createVerticalStrut(5));

        status = new JComboBox<>(TicketStates.values());
        status.setSelectedItem(selectedTicket.getState());
        if (!selectedTicket.isOpen()) status.setEnabled(false);
        status.setBackground(Color.WHITE);
        status.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        status.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        status.setAlignmentX(LEFT_ALIGNMENT);
        p.add(status);
        
        InternalNoteModel internalNote = selectedTicket.getInternalNote();

        if (internalNote == null) {
            p.add(Box.createVerticalStrut(15));
            p.add(italic("Add internal note"));
            p.add(Box.createVerticalStrut(5));

            note = new JTextArea(3, 0);
            note.setLineWrap(true);
            note.setBackground(new Color(255, 250, 240));
            note.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            note.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            JScrollPane ns = new JScrollPane(note);
            ns.setAlignmentX(LEFT_ALIGNMENT);
            ns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
            ns.setBorder(BorderFactory.createLineBorder(new Color(220, 200, 100)));
            p.add(ns);  
            
        } else {
            p.add(Box.createVerticalStrut(15));
            p.add(italic("Internal note"));
            p.add(Box.createVerticalStrut(5));

            note = new JTextArea(3, 0);
            note.setEditable(false);
            note.setLineWrap(true);
            note.setBackground(new Color(255, 250, 240));
            note.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            note.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            note.setText(internalNote.getContent());

            JScrollPane ns = new JScrollPane(note);
            ns.setAlignmentX(LEFT_ALIGNMENT);
            ns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
            ns.setBorder(BorderFactory.createLineBorder(new Color(220, 200, 100)));

            p.add(ns);
        }

        p.add(Box.createVerticalStrut(20));

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btns.setBackground(Color.WHITE);
        btns.setAlignmentX(LEFT_ALIGNMENT);
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btns.add(btn("Save Changes", new Color(0, 120, 215)));
        btns.add(btn("Open Chat", new Color(0, 170, 90)));
        btns.add(btn("Back", new Color(150, 150, 150)));
        p.add(btns);

        p.add(Box.createVerticalStrut(20));
        p.add(sep());
        p.add(Box.createVerticalStrut(15));
        p.add(italic("User feedback"));
        p.add(Box.createVerticalStrut(8));

        FeedbackModel fb = selectedTicket.getFeedback();

        if (fb == null) {
            JLabel noFb = new JLabel("No feedback submitted yet.");
            noFb.setFont(new Font("Segoe UI", Font.ITALIC, 13));
            noFb.setForeground(new Color(160, 160, 160));
            noFb.setAlignmentX(LEFT_ALIGNMENT);
            p.add(noFb);
        } else {
            p.add(infoRow("Rating:", fb.getRating().getValue() + " / 5 ★"));
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
        
        if (t.equals("Save Changes")) {
            b.addActionListener(e -> {
                TicketStates selectedStatus = (TicketStates) status.getSelectedItem();
                if (selectedStatus != selectedTicket.getState()) {
                    if (selectedStatus == TicketStates.CLOSED) {
                        new CloseTicketDialog(this, selectedTicket).setVisible(true);
                    }
                    selectedTicket.setState(selectedStatus);
                }
                
                if (!note.getText().isBlank()) {
                    selectedTicket.setInternalNote(new InternalNoteModel(selectedTicket, selectedTicket.getTechnicianAccount(), note.getText()));
                }
                
                JOptionPane.showMessageDialog(
                    this,
                    "Changes saved",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                owner.setVisible(true);
                dispose();
            });
        } else if (t.equals("Open Chat")) {
            b.addActionListener(e -> {
                new ChatDialog(this, account, selectedTicket.getMessages()).setVisible(true);
            });
        } else {
            b.addActionListener(e -> {
                owner.setVisible(true);
                dispose();
            });
        }
        
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
            TicketDetailDialog dialog = new TicketDetailDialog(null, new TicketModel(
                "No internet in room 5",
                "The workstation in room 5 cannot access the network.",
                PriorityLevels.HIGH,
                null
            ), null);
            dialog.setVisible(true);
        });
    }
}