package DataModels;

public class FeedbackModel {
    private final String feedbackId;
    private final String ticketId;
    private final String userId;
    private final String rating;

    public FeedbackModel(String feedbackId, String ticketId, String userId, String rating) {
        this.feedbackId = feedbackId;
        this.ticketId = ticketId;
        this.userId = userId;
        this.rating = rating;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public String getUserId() {
        return userId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getRating() {
        return rating;
    }
}
