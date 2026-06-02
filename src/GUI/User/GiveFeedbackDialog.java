package GUI.User;

import DataModels.AccountModel;
import DataModels.FeedbackModel;
import DataModels.TicketModel;
import Utils.RatingValues;

import java.awt.*;
import javax.swing.*;

public class GiveFeedbackDialog extends JDialog {

    public GiveFeedbackDialog(JDialog owner, TicketModel ticket, AccountModel account) {
        super(owner, "School Help - Give Feedback", true);
        
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(450, 380);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Give Feedback");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel reviewLbl = new JLabel("Review");
        reviewLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        reviewLbl.setForeground(new Color(80, 80, 80));
        reviewLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea area = new JTextArea(5, 0);
        area.setBackground(Color.WHITE);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setAlignmentX(LEFT_ALIGNMENT);
        scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        scroll.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)));

        JLabel starsLbl = new JLabel("Stars");
        starsLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        starsLbl.setForeground(new Color(80, 80, 80));
        starsLbl.setAlignmentX(LEFT_ALIGNMENT);

        JComboBox<RatingValues> stars = new JComboBox<>(RatingValues.values());
        stars.setSelectedItem(RatingValues.GOOD);
        stars.setBackground(Color.WHITE);
        stars.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        stars.setMaximumSize(new Dimension(100, 36));
        stars.setAlignmentX(LEFT_ALIGNMENT);

        JButton submitBtn = btn("Submit Feedback", new Color(0, 120, 215));
        submitBtn.addActionListener(e -> {
            String reviewText = area.getText().trim();
            if (reviewText.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please write a review before submitting.",
                        "Review Required",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            RatingValues rating = (RatingValues) stars.getSelectedItem();

            ticket.setFeedBack(new FeedbackModel(ticket, account, rating, reviewText));
            JOptionPane.showMessageDialog(
                    this,
                    "Thank you! Your feedback has been saved.",
                    "Feedback Submitted",
                    JOptionPane.INFORMATION_MESSAGE);
            
            owner.setVisible(true);
            dispose();
        });

        JButton cancelBtn = btn("Cancel", new Color(150, 150, 150));
        cancelBtn.addActionListener(e -> {
            owner.setVisible(true);
            dispose();
        });

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btns.setBackground(Color.WHITE);
        btns.setAlignmentX(LEFT_ALIGNMENT);
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btns.add(submitBtn);
        btns.add(cancelBtn);

        p.add(title);
        p.add(Box.createVerticalStrut(20));
        p.add(reviewLbl);
        p.add(Box.createVerticalStrut(5));
        p.add(scroll);
        p.add(Box.createVerticalStrut(15));
        p.add(starsLbl);
        p.add(Box.createVerticalStrut(5));
        p.add(stars);
        p.add(Box.createVerticalStrut(20));
        p.add(btns);

        add(p);
    }

    private JButton btn(String text, Color bg) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GiveFeedbackDialog(null, null, null).setVisible(true));
    }
}
