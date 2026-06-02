package DataModels;

import Utils.RatingValues;

public class FeedbackModel {
    
    private static int NEXT_ID = 0;
    
    private final int feedbackId;
    private final TicketModel ticket;
    private final AccountModel user;
    private final RatingValues rating;
    private final String review;

    public FeedbackModel(TicketModel ticket, AccountModel user, RatingValues rating, String review) {
        this.feedbackId = NEXT_ID;
        NEXT_ID++;
        this.ticket = ticket;
        this.user = user;
        this.rating = rating;
        this.review = review;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public AccountModel getUser() {
        return user;
    }

    public TicketModel getTicket() {
        return ticket;
    }

    public RatingValues getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}
