package GUI.User;

import java.awt.*;
import javax.swing.*;

public class GiveFeedbackFrame extends JFrame {

    public GiveFeedbackFrame() {
        setTitle("School Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 260);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel title = new JLabel("Give Feedback");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel reviewLbl = new JLabel("Review");
        reviewLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        reviewLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea area = new JTextArea(5, 0);
        area.setBackground(Color.WHITE);
        area.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setAlignmentX(LEFT_ALIGNMENT);
        scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));

        JLabel starsLbl = new JLabel("Stars");
        starsLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        starsLbl.setAlignmentX(LEFT_ALIGNMENT);

        JComboBox<String> stars = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        stars.setSelectedItem("4");
        stars.setBackground(Color.WHITE);
        stars.setMaximumSize(new Dimension(80, 28));
        stars.setAlignmentX(LEFT_ALIGNMENT);

        p.add(title);
        p.add(Box.createVerticalStrut(12));
        p.add(reviewLbl);
        p.add(Box.createVerticalStrut(3));
        p.add(scroll);
        p.add(Box.createVerticalStrut(10));
        p.add(starsLbl);
        p.add(Box.createVerticalStrut(3));
        p.add(stars);

        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GiveFeedbackFrame().setVisible(true));
    }
}

