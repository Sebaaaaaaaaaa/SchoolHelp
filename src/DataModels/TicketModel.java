package DataModels;

import Utils.PriorityLevels;
import Utils.TicketStates;
import java.util.Date;

public class TicketModel {
    private final String ticketId;
    private final String title;
    private final String description;
    private final PriorityLevels priority;
    private TicketStates state;
    private final Date createdAt;
    private final int userId;
    private int technicianId;

    public TicketModel(String ticketId, String title, String description, PriorityLevels priority, 
        TicketStates state, Date createdAt, int userId, int technicianId) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.state = state;
        this.createdAt = createdAt;
        this.userId = userId;
        this.technicianId = technicianId;
    }

    public String getTicketId() {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public void setState(TicketStates s) { this.state = s; }
    
    public void setTechnicianId(int id) { this.technicianId = id; }
}
