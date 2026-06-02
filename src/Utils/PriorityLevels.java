package Utils;

public enum PriorityLevels {
    LOW("low"),
    MEDIUM("Medium"),
    HIGH("High"),
    URGENT("Urgent");

    private final String level;

    PriorityLevels(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
