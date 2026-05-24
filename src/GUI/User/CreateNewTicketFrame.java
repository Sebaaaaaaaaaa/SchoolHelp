import java.awt.*;
import javax.swing.*;

public class CreateNewTicketFrame extends JFrame {

    public CreateNewTicketFrame() {
        setTitle("School Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(370, 340);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(212, 208, 200));
        p.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel title = new JLabel("Create New Ticket");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel("Fill in the details to create a support ticket");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        sub.setForeground(new Color(60, 60, 60));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        JLabel titleLbl = new JLabel("Title");
        titleLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        titleLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextField titleField = new JTextField();
        titleField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
        titleField.setAlignmentX(LEFT_ALIGNMENT);

        JLabel descLbl = new JLabel("Description");
        descLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        descLbl.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea descArea = new JTextArea(5, 0);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        JScrollPane descScroll = new JScrollPane(descArea);
        descScroll.setAlignmentX(LEFT_ALIGNMENT);
        descScroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        JLabel prioLbl = new JLabel("Priority");
        prioLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        prioLbl.setAlignmentX(LEFT_ALIGNMENT);

        JComboBox<String> prioCombo = new JComboBox<>(new String[]{"High", "Medium", "Low", "Critical"});
        prioCombo.setBackground(Color.WHITE);
        prioCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        prioCombo.setAlignmentX(LEFT_ALIGNMENT);

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        btns.setBackground(new Color(212, 208, 200));
        btns.setAlignmentX(LEFT_ALIGNMENT);
        btns.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        btns.add(btn("Create Ticket"));
        btns.add(btn("Cancel"));

        p.add(title);
        p.add(Box.createVerticalStrut(2));
        p.add(sub);
        p.add(Box.createVerticalStrut(12));
        p.add(titleLbl);
        p.add(Box.createVerticalStrut(3));
        p.add(titleField);
        p.add(Box.createVerticalStrut(10));
        p.add(descLbl);
        p.add(Box.createVerticalStrut(3));
        p.add(descScroll);
        p.add(Box.createVerticalStrut(10));
        p.add(prioLbl);
        p.add(Box.createVerticalStrut(3));
        p.add(prioCombo);
        p.add(Box.createVerticalStrut(12));
        p.add(btns);

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
        SwingUtilities.invokeLater(() -> new CreateNewTicketFrame().setVisible(true));
    }
}