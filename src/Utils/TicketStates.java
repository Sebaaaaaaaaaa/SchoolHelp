package Utils;

public enum TicketStates {
    OPEN("Open"),
    IN_PROGRESS("In progress"),
    WAITING("Waiting"),
    CLOSED("Closed");

    private final String state;

    TicketStates(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
