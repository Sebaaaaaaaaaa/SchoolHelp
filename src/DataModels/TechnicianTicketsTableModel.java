package DataModels;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TechnicianTicketsTableModel extends DefaultTableModel {

    private static final String[] COLS = { "ID", "Title", "Priority", "State", "Created At", "User ID" };
    private final List<TicketModel> tickets;

    public TechnicianTicketsTableModel(List<TicketModel> tickets) {
        super(COLS, 0);
        this.tickets = tickets;
        if (!tickets.isEmpty()) {
            setData();
        }
    }
    
    public TicketModel getTicketAt(int row) {
        return tickets.get(row);
    }
    
    public void refresh() {
        setRowCount(0);
        setData();
    }
    
    private void setData() {
        for (TicketModel t : tickets) {
            addRow(new Object[]{
                t.getTicketId(),
                t.getTitle(),
                t.getPriority(),
                t.getState(),
                t.getCreatedAt(),
                t.getUserAccount().getAccountId()
            });
        }
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
