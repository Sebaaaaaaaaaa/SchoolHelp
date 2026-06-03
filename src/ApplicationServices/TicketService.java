package ApplicationServices;

import DataModels.AccountModel;
import DataModels.TicketModel;
import Utils.PriorityLevels;
import Utils.TicketStates;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private final List<TicketModel> tickets;
    
    public TicketService() {
        tickets = new ArrayList<>();
    }

    public void createTicket(String title, String description, PriorityLevels priority, AccountModel user) {
        TicketModel ticket = new TicketModel(
                title,
                description,
                priority,
                user
        );
        tickets.add(ticket);
    }

    public TicketModel getTicketById(int ticketId) {
        for (TicketModel ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }

    public List<TicketModel> getTechnicianTickets(int technicianId) {
        List<TicketModel> technicianTickets = new ArrayList<>();
        for (TicketModel ticket : tickets) {
            if (ticket.getTechnicianAccount() != null && ticket.getTechnicianAccount().getAccountId() == technicianId) {
                technicianTickets.add(ticket);
            }
        }
        return technicianTickets;
    }
    
    public List<TicketModel> getUnassignedTickets() {
        List<TicketModel> unassignedTickets = new ArrayList<>();
        for (TicketModel ticket : tickets) {
            if (ticket.getTechnicianAccount() == null) {
                unassignedTickets.add(ticket);
            }
        }
        return unassignedTickets; 
    }
    
    public List<TicketModel> getTicketsByUser(AccountModel user) {
        List<TicketModel> userTickets = new ArrayList<>();
        for (TicketModel ticket : tickets) {
            if (ticket.getUserAccount() == user && !(ticket.getFeedback() != null && !ticket.isOpen())) {
                userTickets.add(ticket);
            }
        }
        return userTickets; 
    } 

    public List<TicketModel> getTickets() {
        return new ArrayList<>(tickets);
    }
    
    public String getActiveTickets() {
        int counter = 0;
        for (TicketModel ticket : tickets) {
            if (ticket.isOpen()) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }
    
    public String getClosedTickets() {
        int counter = 0;
        for (TicketModel ticket : tickets) {
            if (!ticket.isOpen()) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }
    
   public String getTicketsOnHold() {
        int counter = 0;
        for (TicketModel ticket : tickets) {
            if (ticket.getState() == TicketStates.WAITING) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }
}
