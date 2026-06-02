package DataModels;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageModel {
    
    private static int NEXT_ID = 0;
    
    private final int messageId;
    private final TicketModel ticket;
    private final AccountModel sender;
    private final AccountModel receiver;
    private final String content;
    private final String timestamp;

    public MessageModel(TicketModel ticket, AccountModel sender, AccountModel receiver, String content, String timestamp) {
        this.messageId =  NEXT_ID;
        NEXT_ID++;
        this.ticket = ticket;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = format.format(now);
        this.timestamp = formattedDate;
    }

    public int getMessageId() {
        return messageId;
    }

    public TicketModel getTicket() {
        return ticket;
    }

    public AccountModel getSender() {
        return sender;
    }

    public AccountModel getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
