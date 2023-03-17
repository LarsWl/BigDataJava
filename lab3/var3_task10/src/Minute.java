public class Minute {
    private int number;

    public int getNumber() { return number; }

    public Minute(int minute) { this.number = minute; }

    public boolean equals(Minute minute) {
        return number == minute.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public String toString() {
        return String.format("Minute: %s", number);
    }
}
