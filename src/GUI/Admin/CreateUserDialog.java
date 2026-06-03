package GUI.Admin;

import ApplicationServices.AdministrationService;
import Utils.AccountRoles;
import java.awt.*;
import javax.swing.*;

public class CreateUserDialog extends JDialog {

    public CreateUserDialog(JFrame owner, AdministrationService adminService) {
        super(owner, "School Help - Create User", true);
        
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(400, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel title = new JLabel("Create New User");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel("Enter the details to register a new user in the system");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(5));
        panel.add(sub);
        panel.add(Box.createVerticalStrut(20));

        panel.add(lbl("First Name"));
        panel.add(Box.createVerticalStrut(5));
        JTextField nameField = txt();
        panel.add(nameField);
        panel.add(Box.createVerticalStrut(12));

        panel.add(lbl("Last Name"));
        panel.add(Box.createVerticalStrut(5));
        JTextField surnameField = txt();
        panel.add(surnameField);
        panel.add(Box.createVerticalStrut(12));

        panel.add(lbl("Username"));
        panel.add(Box.createVerticalStrut(5));
        JTextField userField = txt();
        panel.add(userField);
        panel.add(Box.createVerticalStrut(12));

        panel.add(lbl("Password"));
        panel.add(Box.createVerticalStrut(5));
        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        passField.setAlignmentX(LEFT_ALIGNMENT);
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        panel.add(passField);
        panel.add(Box.createVerticalStrut(12));

        panel.add(lbl("Role"));
        panel.add(Box.createVerticalStrut(5));
        JComboBox<AccountRoles> roleCombo = new JComboBox<>(AccountRoles.values());
        roleCombo.setBackground(Color.WHITE);
        roleCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        roleCombo.setAlignmentX(LEFT_ALIGNMENT);
        roleCombo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(roleCombo);
        panel.add(Box.createVerticalStrut(25));

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setAlignmentX(LEFT_ALIGNMENT);
        buttonsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        JButton btnCreate = btn("Create", new Color(0, 120, 215));
        btnCreate.addActionListener(e ->{
            String name = nameField.getText();
            String surname = surnameField.getText();
            String username = userField.getText();
            String password = passField.getText();
            AccountRoles role = (AccountRoles) roleCombo.getSelectedItem();
            
            if (nameField.getText().isBlank()) {
               JOptionPane.showMessageDialog(this, "Please enter a name.", "Input Error", JOptionPane.WARNING_MESSAGE);
               return;
            }
            
            if (surnameField.getText().isBlank()) {
               JOptionPane.showMessageDialog(this, "Please enter a surname.", "Input Error", JOptionPane.WARNING_MESSAGE);
               return;
            }
            
            if (userField.getText().isBlank()) {
               JOptionPane.showMessageDialog(this, "Please enter a username.", "Input Error", JOptionPane.WARNING_MESSAGE);
               return;
            }
            
            if (passField.getText().isBlank()) {
               JOptionPane.showMessageDialog(this, "Please enter a password.", "Input Error", JOptionPane.WARNING_MESSAGE);
               return;
            }
            
            adminService.addUser(username, password, name, surname, role);
            
            JOptionPane.showMessageDialog(this, "Added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            owner.setVisible(true);
            dispose();
        });
        JButton btnCancel = btn("Cancel", new Color(150, 150, 150));
        btnCancel.addActionListener(e ->{
            owner.setVisible(true);
            dispose();
        });
        
        buttonsPanel.add(btnCreate);
        buttonsPanel.add(btnCancel);
        panel.add(buttonsPanel);

        add(panel);
    }

    private JLabel lbl(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(80, 80, 80));
        label.setAlignmentX(LEFT_ALIGNMENT);
        return label;
    }

    private JTextField txt() {
        JTextField textField = new JTextField();
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        textField.setAlignmentX(LEFT_ALIGNMENT);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        return textField;
    }

    private JButton btn(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreateUserDialog(null, null).setVisible(true));
    }
}
