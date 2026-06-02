package DataModels;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InternalNoteModel {
    
    private static int NEXT_ID = 0;
    
    private final int noteId;
    private final TicketModel ticket;
    private final AccountModel technicianAccount;
    private final String content;
    private final String createdAt;

    public InternalNoteModel(TicketModel ticket, AccountModel technicianAccount, String content) {
        this.noteId = NEXT_ID;
        NEXT_ID++;
        this.ticket = ticket;
        this.technicianAccount = technicianAccount;
        this.content = content;
        
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = format.format(now);
        this.createdAt = formattedDate;
    }

    public int getNoteId() {
        return noteId;
    }

    public TicketModel getTicket() {
        return ticket;
    }

    public AccountModel getTechnician() {
        return technicianAccount;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
