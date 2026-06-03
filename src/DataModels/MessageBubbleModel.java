package GUI;

import DataModels.MessageModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MessageBubbleModel extends JPanel {

    public MessageBubbleModel(MessageModel message, boolean mine) {

        setLayout(new BorderLayout());
        setOpaque(false);

        JPanel wrapper = new JPanel(
                new FlowLayout(
                        mine ? FlowLayout.RIGHT : FlowLayout.LEFT));

        wrapper.setOpaque(false);

        JPanel bubble = new JPanel();
        bubble.setLayout(new BoxLayout(bubble, BoxLayout.Y_AXIS));

        bubble.setBorder(new EmptyBorder(10, 15, 10, 15));

        bubble.setBackground(
                mine
                        ? new Color(0, 120, 215)
                        : Color.WHITE);

        JLabel senderLabel = new JLabel(
                message.getSender().getUsername() + " | " + message.getSender().getFullName());

        senderLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 11));

        senderLabel.setForeground(
                mine
                        ? Color.WHITE
                        : Color.DARK_GRAY);

        JTextArea content = new JTextArea(
                message.getContent());

        content.setEditable(false);
        content.setWrapStyleWord(true);
        content.setLineWrap(true);
        content.setOpaque(false);

        content.setForeground(
                mine
                        ? Color.WHITE
                        : Color.BLACK);

        content.setFont(
                new Font("Segoe UI", Font.PLAIN, 14));

        JLabel timestamp = new JLabel(
                message.getTimestamp());

        timestamp.setFont(
                new Font("Segoe UI", Font.PLAIN, 10));

        timestamp.setForeground(
                mine
                        ? new Color(230, 230, 230)
                        : Color.GRAY);

        bubble.add(senderLabel);
        bubble.add(Box.createVerticalStrut(5));
        bubble.add(content);
        bubble.add(Box.createVerticalStrut(5));
        bubble.add(timestamp);

        bubble.setMaximumSize(
                new Dimension(350, Integer.MAX_VALUE));

        wrapper.add(bubble);

        add(wrapper, BorderLayout.CENTER);
    }
}