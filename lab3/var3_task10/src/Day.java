public class Day {
    private Hour hour;
    private Minute minute;

    public Day(int hour, int minute) {
        this.hour = new Hour(hour);
        this.minute = new Minute(minute);
    }

    public boolean equals(Day day) {
        return hour.equals(day.hour) && minute.equals(day.minute);
    }

    @Override
    public int hashCode() {
        return hour.hashCode() * minute.hashCode();
    }

    public String toString() {
        return hour.toString() + "\n" + minute.toString();
    }

    public String partOfDay() {
        if (hour.getNumber() >= 0 && hour.getNumber() < 6) {
            return "Night";
        } else if (hour.getNumber() >= 6 && hour.getNumber() < 12) {
            return "Morning";
        } else if (hour.getNumber() >= 12 && hour.getNumber() < 18) {
            return "Day";
        } else {
            return "Evening";
        }
    }
}
