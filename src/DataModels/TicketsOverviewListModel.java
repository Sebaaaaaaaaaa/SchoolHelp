package DataModels;

import javax.swing.DefaultListModel;
import java.util.List;

public class TicketsOverviewListModel extends DefaultListModel<String> {

    private final List<TicketModel> tickets;

    public TicketsOverviewListModel(List<TicketModel> tickets) {
        this.tickets = tickets;

        for (TicketModel t : tickets) {
            addElement(
                "Ticket #" + t.getTicketId() +
                ", Status: " + t.getState().getState() +
                ", Priority: " + t.getPriority().getLevel() +
                ", User: " + t.getUserAccount().getFullName() +
                ", Technician: " + (t.getTechnicianAccount() != null? t.getTechnicianAccount().getFullName(): "None"));
        }
    }

    public TicketModel getTicketAt(int index) {
        return tickets.get(index);
    }
}
