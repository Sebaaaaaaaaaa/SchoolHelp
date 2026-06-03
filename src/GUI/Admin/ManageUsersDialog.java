package GUI.Admin;

import ApplicationServices.AdministrationService;
import ApplicationServices.TicketService;
import DataModels.AccountModel;
import DataModels.UsersListModel;
import GUI.LoginFrame;
import Utils.AccountRoles;
import java.awt.*;
import javax.swing.*;

public class ManageUsersDialog extends JDialog {
    
    private final JFrame owner;
    private final AdministrationService adminService;
    private final TicketService ticketService;
    private AccountModel selectedUser;
    private JComboBox<AccountRoles> perm;
    private JTextField pass;
    private JTextField user;
    private final JList<String> list;
    private final AccountModel account;

    public ManageUsersDialog(JFrame owner, AdministrationService adminService, TicketService ticketService, AccountModel account) {
        super(owner, "School Help - Manage Users", true);
        
        this.owner = owner;
        this.adminService = adminService;
        this.ticketService = ticketService;
        this.selectedUser = null;
        this.account = account;
        
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Manage Users");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);
        JLabel sub = new JLabel("Manage users, change their permissions and passwords");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(new Color(120, 120, 120));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JPanel center = new JPanel(new BorderLayout(15, 0));
        center.setBackground(Color.WHITE);
        center.setAlignmentX(LEFT_ALIGNMENT);
        center.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBackground(Color.WHITE);
        
        form.add(lbl("Username")); form.add(Box.createVerticalStrut(5));
        user = new JTextField();
        user.setEditable(false);
        user.setMaximumSize(new Dimension(Integer.MAX_VALUE,36)); 
        user.setAlignmentX(LEFT_ALIGNMENT); 
        user.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        user.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        form.add(user);
        form.add(Box.createVerticalStrut(10));
        
        form.add(lbl("Password")); form.add(Box.createVerticalStrut(5));
        pass = new JTextField();
        pass.setEditable(false);
        pass.setMaximumSize(new Dimension(Integer.MAX_VALUE,36)); 
        pass.setAlignmentX(LEFT_ALIGNMENT); 
        pass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pass.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        form.add(pass);
        form.add(Box.createVerticalStrut(10));
        
        form.add(lbl("Permission")); form.add(Box.createVerticalStrut(5));
        perm = new JComboBox<>(AccountRoles.values());
        perm.setEnabled(false);
        perm.setBackground(Color.WHITE); 
        perm.setMaximumSize(new Dimension(Integer.MAX_VALUE,36)); 
        perm.setAlignmentX(LEFT_ALIGNMENT);
        perm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        form.add(perm);

        list = new JList<>(new UsersListModel(adminService.getUsers()));
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = list.getSelectedIndex();
                
                if (row > -1) {
                    selectedUser = ((UsersListModel) list.getModel()).getUserAt(row);
                    
                    user.setEditable(true);
                    user.setText(selectedUser.getUsername());
                    pass.setEditable(true);
                    pass.setText(selectedUser.getPassword());

                    perm.setEnabled(true);
                    perm.setSelectedItem(selectedUser.getRole());  
                }
            }
        });
        list.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        list.setBackground(Color.WHITE);
        list.setForeground(new Color(60, 60, 60));
        JScrollPane ls = new JScrollPane(list);
        ls.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        ls.setPreferredSize(new Dimension(180, 0));

        center.add(form, BorderLayout.CENTER);
        center.add(ls, BorderLayout.EAST);

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btns.setBackground(Color.WHITE); 
        btns.setAlignmentX(LEFT_ALIGNMENT); 
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btns.add(btn("Update", new Color(0, 120, 215))); 
        btns.add(btn("Cancel", new Color(150, 150, 150)));

        p.add(title); 
        p.add(Box.createVerticalStrut(5)); 
        p.add(sub);
        p.add(Box.createVerticalStrut(20)); 
        p.add(center);
        p.add(Box.createVerticalStrut(20)); 
        p.add(btns);
        add(p);
    }

    private JLabel lbl(String t) { 
        JLabel l = new JLabel(t); 
        l.setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        l.setForeground(new Color(80, 80, 80)); 
        l.setAlignmentX(LEFT_ALIGNMENT); 
        return l; 
    }
    
    private JButton btn(String t, Color bg) { 
        JButton b = new JButton(t); 
        b.setFont(new Font("Segoe UI", Font.BOLD, 14)); 
        b.setBackground(bg); 
        b.setForeground(Color.WHITE); 
        b.setFocusPainted(false); 
        b.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        if (t.equals("Update")) {
            b.addActionListener(e -> {
                if (!list.isSelectionEmpty()) {
                    selectedUser.setUsername(user.getText());
                    selectedUser.setPassword(pass.getText());  
                    selectedUser.setRole((AccountRoles) perm.getSelectedItem());
                    
                    list.setModel(new UsersListModel(adminService.getUsers()));
                    
                    JOptionPane.showMessageDialog(this,
                        "Updated successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                    if (selectedUser.getAccountId() == account.getAccountId()) {
                        new LoginFrame(ticketService, adminService).setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a user.", "Selection Error", JOptionPane.WARNING_MESSAGE);
                }
            });
        } else {
            b.addActionListener(e -> {
                owner.setVisible(true);
                dispose();
            });
        }
        
        return b; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManageUsersDialog(null, null, null, null).setVisible(true));
    }
}

