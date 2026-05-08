package CsvModels;

public class MessageModel {
    private final String messageId;
    private final String ticketId;
    private final String senderId;
    private final String receiverId;
    private final String content;
    private final String timestamp;

    public MessageModel(String messageId, String ticketId, String senderId, String receiverId, String content, String timestamp) {
        this.messageId = messageId;
        this.ticketId = ticketId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
