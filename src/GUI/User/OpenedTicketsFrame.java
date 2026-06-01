package GUI.User;

import ApplicationServices.TicketService;
import DataModels.TicketModel;
import Utils.TicketStates;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;

public class OpenedTicketsFrame extends JFrame {

    public OpenedTicketsFrame() {
        setTitle("School Help - Opened Tickets");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        List<TicketModel> tickets = TicketService.getTickets().stream()
                .filter(t -> t.getState() != TicketStates.CLOSED)
                .collect(Collectors.toList());
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy, hh:mm a");

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Opened Tickets");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel(tickets.size() + " ticket(s) total");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        sep.setAlignmentX(LEFT_ALIGNMENT);
        sep.setForeground(new Color(230, 230, 230));

        p.add(title);
        p.add(Box.createVerticalStrut(5));
        p.add(sub);
        p.add(Box.createVerticalStrut(15));
        p.add(sep);
        p.add(Box.createVerticalStrut(20));

        if (tickets.isEmpty()) {
            JLabel empty = new JLabel("No tickets found.");
            empty.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            empty.setForeground(new Color(160, 160, 160));
            empty.setAlignmentX(LEFT_ALIGNMENT);
            p.add(empty);
            p.add(Box.createVerticalStrut(20));
        } else {
            for (TicketModel ticket : tickets) {
                p.add(buildTicketCard(ticket, sdf));
                p.add(Box.createVerticalStrut(15));
            }
        }

        JPanel bottomRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        bottomRow.setBackground(Color.WHITE);
        bottomRow.setAlignmentX(LEFT_ALIGNMENT);
        bottomRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        JButton cancelBtn = btn("Cancel", new Color(150, 150, 150));
        cancelBtn.addActionListener(e -> dispose());
        bottomRow.add(cancelBtn);
        p.add(bottomRow);

        JScrollPane scroll = new JScrollPane(p);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll);
    }

    private JPanel buildTicketCard(TicketModel ticket, SimpleDateFormat sdf) {
        JPanel card = new JPanel(new BorderLayout(15, 0));
        card.setBackground(Color.WHITE);
        card.setAlignmentX(LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);

        JLabel ticketName = new JLabel(ticket.getTitle());
        ticketName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        ticketName.setForeground(new Color(40, 40, 40));
        ticketName.setAlignmentX(LEFT_ALIGNMENT);

        JLabel ticketDate = new JLabel("Created on " + sdf.format(ticket.getCreatedAt()));
        ticketDate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        ticketDate.setForeground(new Color(120, 120, 120));
        ticketDate.setAlignmentX(LEFT_ALIGNMENT);

        JLabel stateLbl = new JLabel(
                "State: " + ticket.getState().name() + "  |  Priority: " + ticket.getPriority().name());
        stateLbl.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        stateLbl.setForeground(new Color(80, 100, 200));
        stateLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea desc = new JTextArea(ticket.getDescription());
        desc.setEditable(false);
        desc.setBackground(new Color(245, 245, 245));
        desc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        desc.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        JScrollPane ds = new JScrollPane(desc);
        ds.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        ds.setPreferredSize(new Dimension(300, 70));

        infoPanel.add(ticketName);
        infoPanel.add(Box.createVerticalStrut(3));
        infoPanel.add(ticketDate);
        infoPanel.add(Box.createVerticalStrut(3));
        infoPanel.add(stateLbl);
        infoPanel.add(Box.createVerticalStrut(6));
        infoPanel.add(ds);

        JPanel actionBtns = new JPanel();
        actionBtns.setLayout(new BoxLayout(actionBtns, BoxLayout.Y_AXIS));
        actionBtns.setBackground(Color.WHITE);
        actionBtns.add(btn("Ticket Status", new Color(0, 120, 215)));
        actionBtns.add(Box.createVerticalStrut(8));
        JButton commentBtn = btn("Add Comment", new Color(0, 120, 215));
        commentBtn.addActionListener(e -> {
            AddCommentFrame addCommentFrame = new AddCommentFrame(ticket.getTicketId());
            addCommentFrame.setVisible(true);
        });
        actionBtns.add(commentBtn);
        actionBtns.add(Box.createVerticalStrut(8));

        JButton closeBtn = btn("Close Ticket", new Color(200, 50, 50));
        closeBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to close this ticket?",
                    "Close Ticket Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                TicketService.closeTicket(ticket.getTicketId());
                JOptionPane.showMessageDialog(this, "Ticket closed successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new OpenedTicketsFrame().setVisible(true);
            }
        });
        actionBtns.add(closeBtn);
        actionBtns.add(Box.createVerticalStrut(8));

        JButton feedbackBtn = btn("Give Feedback", new Color(100, 180, 100));
        feedbackBtn.addActionListener(e -> {
            GiveFeedbackFrame feedbackFrame = new GiveFeedbackFrame(ticket.getTicketId());
            feedbackFrame.setVisible(true);
        });
        actionBtns.add(feedbackBtn);

        card.add(infoPanel, BorderLayout.CENTER);
        card.add(actionBtns, BorderLayout.EAST);

        return card;
    }

    private JButton btn(String text, Color bg) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 12));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setPreferredSize(new Dimension(130, 32));
        b.setMaximumSize(new Dimension(130, 32));
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OpenedTicketsFrame().setVisible(true));
    }
}
