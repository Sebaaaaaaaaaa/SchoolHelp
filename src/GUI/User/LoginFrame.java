package GUI.User;

import ApplicationServices.AuthenticationService;
import DataModels.AccountModel;
import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("School Help - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 420);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel institute = new JLabel("Istituto Cristoforo Colombo");
        institute.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        institute.setForeground(new Color(120, 120, 120));
        institute.setAlignmentX(CENTER_ALIGNMENT);

        JLabel title = new JLabel("School Help");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel userLbl = new JLabel("Username");
        userLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        userLbl.setForeground(new Color(80, 80, 80));
        userLbl.setAlignmentX(CENTER_ALIGNMENT);

        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        userField.setAlignmentX(CENTER_ALIGNMENT);
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        JLabel passLbl = new JLabel("Password");
        passLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        passLbl.setForeground(new Color(80, 80, 80));
        passLbl.setAlignmentX(CENTER_ALIGNMENT);

        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        passField.setAlignmentX(CENTER_ALIGNMENT);
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(0, 120, 215));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setFocusPainted(false);
        btnLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnLogin.setAlignmentX(CENTER_ALIGNMENT);
        btnLogin.setBorder(BorderFactory.createEmptyBorder());
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        AuthenticationService authService = new AuthenticationService();
        btnLogin.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            AccountModel account = authService.login(username, password);
            if (account != null) {
                switch (account.getRole()) {
                    case ADMIN -> new GUI.Admin.AdminDashboard().setVisible(true);
                    case USER -> new GUI.User.UserDashboard().setVisible(true);
                    case TECHNICIAN -> new GUI.Technician.TechnicianDashboard().setVisible(true);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        JLabel footer = new JLabel("Laboratory: MULTI 2");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(new Color(150, 150, 150));
        footer.setAlignmentX(CENTER_ALIGNMENT);

        p.add(institute);
        p.add(Box.createVerticalStrut(5));
        p.add(title);
        p.add(Box.createVerticalStrut(25));
        p.add(userLbl);
        p.add(Box.createVerticalStrut(5));
        p.add(userField);
        p.add(Box.createVerticalStrut(15));
        p.add(passLbl);
        p.add(Box.createVerticalStrut(5));
        p.add(passField);
        p.add(Box.createVerticalStrut(25));
        p.add(btnLogin);
        p.add(Box.createVerticalStrut(20));
        p.add(footer);

        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
