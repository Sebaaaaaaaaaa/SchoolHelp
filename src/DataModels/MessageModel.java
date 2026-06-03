package DataModels;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageModel {
    
    private static int NEXT_ID = 0;
    
    private final int messageId;
    private final AccountModel sender;
    private final String content;
    private final String timestamp;

    public MessageModel(AccountModel sender, String content) {
        this.messageId =  NEXT_ID;
        NEXT_ID++;
        this.sender = sender;
        this.content = content;
        
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = format.format(now);
        this.timestamp = formattedDate;
    }

    public int getMessageId() {
        return messageId;
    }

    public AccountModel getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
