package Utils;

public enum PriorityLevels {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    URGENT(4);

    private final int level;

    PriorityLevels(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
