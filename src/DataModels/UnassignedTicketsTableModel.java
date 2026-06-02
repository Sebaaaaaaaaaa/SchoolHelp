package DataModels;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UnassignedTicketsTableModel extends DefaultTableModel {

    private static final String[] COLS = { "ID", "Title", "Priority", "Date" };
    private final List<TicketModel> tickets;

    public UnassignedTicketsTableModel(List<TicketModel> tickets) {
        super(COLS, 0);
        this.tickets = tickets;
        for (TicketModel t : tickets) {
            addRow(new Object[]{
                t.getTicketId(),
                t.getTitle(),
                t.getPriority(),
                t.getCreatedAt(),
            });
        }
    }
    
    public TicketModel getTicketAt(int row) {
        return tickets.get(row);
    }
    
    public void removeTicketAt(int row) {
        tickets.remove(row);
        removeRow(row);
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
