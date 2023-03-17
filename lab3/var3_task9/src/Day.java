public class Day {
    private int number;

    public Day(int number) {
        this.number = number;
    }

    public int getNumber() { return number; }

    public int hashCode() {
        return number;
    }

    public String toString() {
        return String.format("Day: %s", number);
    }

    public boolean equals(Day day) {
        return this.number == day.number;
    }

    public static String[] NAMES = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };
}
