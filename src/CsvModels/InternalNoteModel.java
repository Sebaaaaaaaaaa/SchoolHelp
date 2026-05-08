package CsvModels;

public class InternalNoteModel {
    private final String noteId;
    private final String ticketId;
    private final String technicianId;
    private final String content;
    private final String createdAt;

    public InternalNoteModel(String noteId, String ticketId, String technicianId, String content, String createdAt) {
        this.noteId = noteId;
        this.ticketId = ticketId;
        this.technicianId = technicianId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getNoteId() {
        return noteId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
