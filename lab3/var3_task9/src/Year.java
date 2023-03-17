public class Year {

    private Month month;
    private Day day;

    public Year(int month, int day) {
        this.setDate(month, day);
    }

    public void setDate(int month, int day) {
        this.month = Year.MONTHS[month - 1];
        this.day = new Day(day);
    }

    public static final Month[] MONTHS = {
            new Month("January", 31),
            new Month("February", 28),
            new Month("March", 31),
            new Month("April", 30),
            new Month("May", 31),
            new Month("June", 30),
            new Month("July", 31),
            new Month("August", 31),
            new Month("September", 30),
            new Month("October", 31),
            new Month("November", 30),
            new Month("December", 31)
    };
}
