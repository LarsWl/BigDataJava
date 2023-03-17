public class Hour {
    private int number;

    public Hour(int hour) { this.number = hour; }

    public int getNumber() { return number; }

    public boolean equals(Hour hour) {
        return number == hour.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public String toString() {
        return String.format("Hour: %s", number);
    }
}
