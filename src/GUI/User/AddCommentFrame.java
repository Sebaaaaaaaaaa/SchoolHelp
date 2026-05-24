package GUI.User;

import java.awt.*;
import javax.swing.*;

public class AddCommentFrame extends JFrame {

    public AddCommentFrame() {
        setTitle("School Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 220);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel(new BorderLayout(0, 10));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel title = new JLabel("Add Comment");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));

        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 200), 1));

        JPanel btns = new JPanel(new BorderLayout());
        btns.setBackground(new Color(212, 208, 200));
        btns.add(btn("Confirm"), BorderLayout.WEST);
        btns.add(btn("Cancel"),  BorderLayout.EAST);

        p.add(title,  BorderLayout.NORTH);
        p.add(scroll, BorderLayout.CENTER);
        p.add(btns,   BorderLayout.SOUTH);

        add(p);
    }

    private JButton btn(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("SansSerif", Font.PLAIN, 12));
        b.setBackground(new Color(212, 208, 200));
        b.setFocusPainted(false);
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddCommentFrame().setVisible(true));
    }
}

