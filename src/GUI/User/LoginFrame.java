package GUI.User;

import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("School Help");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        JLabel institute = new JLabel("Istituto Cristoforo Colombo");
        institute.setFont(new Font("SansSerif", Font.PLAIN, 12));
        institute.setAlignmentX(CENTER_ALIGNMENT);

        JLabel title = new JLabel("School Help");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel userLbl = new JLabel("Username");
        userLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        userLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
        userField.setAlignmentX(LEFT_ALIGNMENT);
        userField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 200), 1));

        JLabel passLbl = new JLabel("Password");
        passLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        passLbl.setAlignmentX(LEFT_ALIGNMENT);

        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
        passField.setAlignmentX(LEFT_ALIGNMENT);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(212, 208, 200));
        btnLogin.setFocusPainted(false);
        btnLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        btnLogin.setAlignmentX(LEFT_ALIGNMENT);

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("SansSerif", Font.PLAIN, 11));
        footer.setForeground(new Color(80, 80, 80));
        footer.setAlignmentX(CENTER_ALIGNMENT);

        p.add(institute);
        p.add(Box.createVerticalStrut(2));
        p.add(title);
        p.add(Box.createVerticalStrut(14));
        p.add(userLbl);
        p.add(userField);
        p.add(Box.createVerticalStrut(8));
        p.add(passLbl);
        p.add(passField);
        p.add(Box.createVerticalStrut(10));
        p.add(btnLogin);
        p.add(Box.createVerticalStrut(14));
        p.add(footer);

        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
