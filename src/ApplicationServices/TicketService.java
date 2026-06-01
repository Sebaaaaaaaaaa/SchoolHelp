package ApplicationServices;

import DataModels.FeedbackModel;
import DataModels.MessageModel;
import DataModels.TicketModel;
import Utils.PriorityLevels;
import Utils.TicketStates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TicketService {

    private static final List<TicketModel> tickets = new ArrayList<>();
    private static final List<FeedbackModel> feedbacks = new ArrayList<>();
    private static final List<MessageModel> messages = new ArrayList<>();

    static {
        TicketModel dummy = new TicketModel(
                UUID.randomUUID().toString(),
                "Cannot access school portal",
                "I am unable to log into the school portal since yesterday. "
                        + "I keep getting an 'Invalid credentials' error even though my password is correct. "
                        + "Please help as soon as possible.",
                PriorityLevels.HIGH,
                TicketStates.OPEN,
                new Date(),
                1,
                0);
        tickets.add(dummy);
    }

    public static void createTicket(String title, String description,
            PriorityLevels priority, int userId) {
        TicketModel ticket = new TicketModel(
                UUID.randomUUID().toString(),
                title,
                description,
                priority,
                TicketStates.OPEN,
                new Date(),
                userId,
                0);
        tickets.add(ticket);
    }

    public static List<TicketModel> getTickets() {
        return new ArrayList<>(tickets);
    }

    public static void saveFeedback(String ticketId, String userId, String rating, String review) {
        FeedbackModel fb = new FeedbackModel(
                UUID.randomUUID().toString(),
                ticketId,
                userId,
                rating,
                review);
        feedbacks.add(fb);
    }

    public static FeedbackModel getFeedbackForTicket(String ticketId) {
        return feedbacks.stream()
                .filter(f -> f.getTicketId().equals(ticketId))
                .findFirst()
                .orElse(null);
    }

    public static void addComment(String ticketId, String senderId, String content) {
        MessageModel msg = new MessageModel(
                UUID.randomUUID().toString(),
                ticketId,
                senderId,
                "",
                content,
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        messages.add(msg);
    }

    public static List<MessageModel> getCommentsForTicket(String ticketId) {
        List<MessageModel> result = new ArrayList<>();
        for (MessageModel msg : messages) {
            if (msg.getTicketId().equals(ticketId)) {
                result.add(msg);
            }
        }
        return result;
    }

    public static void closeTicket(String ticketId) {
        for (TicketModel ticket : tickets) {
            if (ticket.getTicketId().equals(ticketId)) {
                ticket.setState(TicketStates.CLOSED);
                break;
            }
        }
    }
}
