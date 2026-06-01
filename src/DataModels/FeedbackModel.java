package DataModels;

public class FeedbackModel {
    private final String feedbackId;
    private final String ticketId;
    private final String userId;
    private final String rating;
    private final String review;

    public FeedbackModel(String feedbackId, String ticketId, String userId, String rating, String review) {
        this.feedbackId = feedbackId;
        this.ticketId = ticketId;
        this.userId = userId;
        this.rating = rating;
        this.review = review;
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

    public String getReview() {
        return review;
    }
}
