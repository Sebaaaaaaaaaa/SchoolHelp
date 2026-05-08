package Utils;

public enum TicketStates {
    OPEN(1),
    IN_PROGRESS(2),
    RESOLVED(3),
    CLOSED(4);

    private final int state;

    TicketStates(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
