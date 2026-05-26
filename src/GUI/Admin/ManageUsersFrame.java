package GUI.Admin;

import java.awt.*;
import javax.swing.*;

public class ManageUsersFrame extends JFrame {

    public ManageUsersFrame() {
        setTitle("School Help - Manage Users");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        JTextField user = new JTextField(); 
        user.setMaximumSize(new Dimension(Integer.MAX_VALUE,36)); 
        user.setAlignmentX(LEFT_ALIGNMENT); 
        user.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        user.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        form.add(user);
        form.add(Box.createVerticalStrut(10));
        
        form.add(lbl("Password")); form.add(Box.createVerticalStrut(5));
        JPasswordField pass = new JPasswordField(); 
        pass.setMaximumSize(new Dimension(Integer.MAX_VALUE,36)); 
        pass.setAlignmentX(LEFT_ALIGNMENT); 
        pass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pass.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        form.add(pass);
        form.add(Box.createVerticalStrut(10));
        
        form.add(lbl("Permission")); form.add(Box.createVerticalStrut(5));
        JComboBox<String> perm = new JComboBox<>(new String[]{"Student","Operator","Administrator"}); 
        perm.setBackground(Color.WHITE); 
        perm.setMaximumSize(new Dimension(Integer.MAX_VALUE,36)); 
        perm.setAlignmentX(LEFT_ALIGNMENT);
        perm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        form.add(perm);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("fcipollone, Administrator");
        model.addElement("prenna, Student");
        model.addElement("fscionti, Operator");
        JList<String> list = new JList<>(model);
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
        return b; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManageUsersFrame().setVisible(true));
    }
}

