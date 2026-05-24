package GUI.Admin;

import java.awt.*;
import javax.swing.*;

public class ManageUsersFrame extends JFrame {

    public ManageUsersFrame() {
        setTitle("School Help – Manage Users");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(430, 290);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel title = new JLabel("Manage Users");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);
        JLabel sub = new JLabel("Manage users, change their permissions and passwords");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        sub.setForeground(new Color(60,60,60));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JPanel center = new JPanel(new BorderLayout(12, 0));
        center.setBackground(new Color(212,208,200));
        center.setAlignmentX(LEFT_ALIGNMENT);
        center.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBackground(new Color(212,208,200));
        form.add(lbl("Username")); form.add(Box.createVerticalStrut(3));
        JTextField user = new JTextField(); user.setMaximumSize(new Dimension(Integer.MAX_VALUE,26)); user.setAlignmentX(LEFT_ALIGNMENT); form.add(user);
        form.add(Box.createVerticalStrut(8));
        form.add(lbl("Password")); form.add(Box.createVerticalStrut(3));
        JPasswordField pass = new JPasswordField(); pass.setMaximumSize(new Dimension(Integer.MAX_VALUE,26)); pass.setAlignmentX(LEFT_ALIGNMENT); form.add(pass);
        form.add(Box.createVerticalStrut(8));
        form.add(lbl("Permission")); form.add(Box.createVerticalStrut(3));
        JComboBox<String> perm = new JComboBox<>(new String[]{"Student","Operator","Administrator"}); perm.setBackground(Color.WHITE); perm.setMaximumSize(new Dimension(Integer.MAX_VALUE,28)); perm.setAlignmentX(LEFT_ALIGNMENT); form.add(perm);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("fcipollone, Administrator");
        model.addElement("prenna, Student");
        model.addElement("fscionti, Operator");
        JList<String> list = new JList<>(model);
        list.setFont(new Font("SansSerif",Font.PLAIN,12));
        list.setBackground(Color.WHITE);
        JScrollPane ls = new JScrollPane(list);
        ls.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
        ls.setPreferredSize(new Dimension(160,0));

        center.add(form, BorderLayout.CENTER);
        center.add(ls,   BorderLayout.EAST);

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT,8,0));
        btns.setBackground(new Color(212,208,200)); btns.setAlignmentX(LEFT_ALIGNMENT); btns.setMaximumSize(new Dimension(Integer.MAX_VALUE,36));
        btns.add(btn("Update")); btns.add(btn("Cancel"));

        p.add(title); p.add(Box.createVerticalStrut(2)); p.add(sub);
        p.add(Box.createVerticalStrut(12)); p.add(center);
        p.add(Box.createVerticalStrut(10)); p.add(btns);
        add(p);
    }

    private JLabel lbl(String t) { JLabel l = new JLabel(t); l.setFont(new Font("SansSerif",Font.PLAIN,12)); l.setAlignmentX(LEFT_ALIGNMENT); return l; }
    private JButton btn(String t) { JButton b = new JButton(t); b.setFont(new Font("SansSerif",Font.PLAIN,12)); b.setBackground(new Color(212,208,200)); b.setFocusPainted(false); return b; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManageUsersFrame().setVisible(true));
    }
}

