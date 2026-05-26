package GUI.User;

import java.awt.*;
import javax.swing.*;

public class AddCommentFrame extends JFrame {

    public AddCommentFrame() {
        setTitle("School Help - Add Comment");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel(new BorderLayout(0, 15));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Add Comment");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(2, 2, 2, 2)));

        JPanel btns = new JPanel(new BorderLayout());
        btns.setBackground(Color.WHITE);
        btns.add(btn("Confirm", new Color(0, 120, 215)), BorderLayout.WEST);
        btns.add(btn("Cancel", new Color(150, 150, 150)),  BorderLayout.EAST);

        p.add(title,  BorderLayout.NORTH);
        p.add(scroll, BorderLayout.CENTER);
        p.add(btns,   BorderLayout.SOUTH);

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
        SwingUtilities.invokeLater(() -> new AddCommentFrame().setVisible(true));
    }
}

