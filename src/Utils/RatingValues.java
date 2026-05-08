package Utils;

public enum RatingValues {
    EXCELLENT(5),
    GOOD(4),
    AVERAGE(3),
    POOR(2),
    TERRIBLE(1);

    private final int value;

    RatingValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
