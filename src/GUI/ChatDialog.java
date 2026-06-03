package GUI;

import DataModels.AccountModel;
import DataModels.MessageModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChatDialog extends JDialog {

    private final JPanel messagesPanel;
    private final JTextField messageField;
    private final List<MessageModel> messages;
    private final JScrollPane scrollPane;
    private final AccountModel account;

    public ChatDialog(JDialog owner, AccountModel account, List<MessageModel> messages) {

        super(owner, "Chat", true);
        
        this.messages = messages;
        this.account = account;

        setSize(600, 700);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        messagesPanel = new JPanel();
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        messagesPanel.setBackground(new Color(245, 245, 245));

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(new Color(245, 245, 245));
        wrapper.add(messagesPanel, BorderLayout.NORTH);

        scrollPane = new JScrollPane(wrapper);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);

        for (MessageModel message : messages) {
            boolean mine =
                    message.getSender().getAccountId()
                    == account.getAccountId();

            messagesPanel.add(new MessageBubbleModel(message, mine));
        }

        messagesPanel.revalidate();
        messagesPanel.repaint();

        SwingUtilities.invokeLater(this::scrollToBottom);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        messageField = new JTextField();

        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(e -> {
            sendMessage();
        });
        
        InputMap im = messageField.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap am = messageField.getActionMap();
        
        im.put(KeyStroke.getKeyStroke("ENTER"), "sendMessage");

        am.put("sendMessage", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                sendMessage();
            }
        });

        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void scrollToBottom() {
        JScrollBar bar = scrollPane.getVerticalScrollBar();
        bar.setValue(bar.getMaximum());
    }
    
    private void sendMessage() {
        String content = messageField.getText().trim();

        if (content.isBlank()) {
            return;
        }

        MessageModel message = new MessageModel(
                account,
                content
        );

        messages.add(message);

        messagesPanel.add(new MessageBubbleModel(message, true));
        messagesPanel.revalidate();
        messagesPanel.repaint();

        messageField.setText("");

        SwingUtilities.invokeLater(this::scrollToBottom);
    }
}