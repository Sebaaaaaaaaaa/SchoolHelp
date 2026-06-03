package DataModels;

import Utils.PriorityLevels;
import Utils.TicketStates;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketModel {
    
    private static int NEXT_ID = 0;
    
    private final int ticketId;
    private final String title;
    private final String description;
    private PriorityLevels priority;
    private TicketStates state;
    private final String createdAt;
    private final AccountModel userAccount;
    private AccountModel technicianAccount;
    private FeedbackModel feedback;
    private InternalNoteModel internalNote;
    private final List<MessageModel> messages;
    private String waitingReason;
    private String closingReason;

    public TicketModel(String title, String description, PriorityLevels priority, AccountModel userAccount) {
        this.ticketId = NEXT_ID;
        NEXT_ID++;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.state = TicketStates.OPEN;
        
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = format.format(now);
        this.createdAt = formattedDate;
        
        this.userAccount = userAccount;
        this.technicianAccount = null;
        this.feedback = null;
        this.internalNote = null;
        this.messages = new ArrayList<>();
        this.waitingReason = null;
        this.closingReason = null;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public PriorityLevels getPriority() {
        return priority;
    }

    public TicketStates getState() {
        return state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public AccountModel getUserAccount() {
        return userAccount;
    }

    public AccountModel getTechnicianAccount() {
        return technicianAccount;
    }

    public void setState(TicketStates state) { this.state = state; }
       
    public void setFeedBack(FeedbackModel feedback) { this.feedback = feedback; }

    public FeedbackModel getFeedback() { return this.feedback; }
    
    public void addMessage(MessageModel message) {messages.add(message);}
    
    public void setTechnician(AccountModel technicianAccount) {this.technicianAccount = technicianAccount;}

    public InternalNoteModel getInternalNote() {
        return internalNote;
    }

    public void setInternalNote(InternalNoteModel internalNote) {
        this.internalNote = internalNote;
    }
    
    public boolean isOpen() {
        return (state != TicketStates.CLOSED);
    }

    public void setPriority(PriorityLevels priority) {
        this.priority = priority;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public String getWaitingReason() {
        return waitingReason;
    }

    public void setWaitingReason(String waitingReason) {
        this.waitingReason = waitingReason;
    }

    public String getClosingReason() {
        return closingReason;
    }

    public void setClosingReason(String closingReason) {
        this.closingReason = closingReason;
    }
}
