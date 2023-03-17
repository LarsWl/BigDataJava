import java.util.Date;

public class Year {

    private int number;
    private Month month;
    private Day day;

    public Year(int year, int month, int day) {
        this.setDate(year, month, day);
    }

    public Month getMonth() { return month; }
    public Day getDay() { return day; }

    public void setDate(int year, int month, int day) {
        this.number = year;
        this.month = Year.MONTHS[month - 1];
        this.day = new Day(day);
    }

    public String dayOfWeek() {
        return Day.NAMES[toDate().getDay()];
    }

    public Date toDate() {
        return new Date(number, month.getNumber(), day.getNumber());
    }

    public static final Month[] MONTHS = {
            new Month("January", 1,31),
            new Month("February", 2,28),
            new Month("March", 3,31),
            new Month("April", 4, 30),
            new Month("May", 5,31),
            new Month("June", 6,30),
            new Month("July", 7,31),
            new Month("August", 8,31),
            new Month("September", 9, 30),
            new Month("October", 10, 31),
            new Month("November", 11,30),
            new Month("December", 12, 31)
    };

    public static int[] calcPeriod(Year begin, Year end) {
        int passedDays = 0;
        int passedMonthes = 0;

        Month begin_month = begin.getMonth();
        Month end_month = end.getMonth();

        if (begin_month.getNumber() == end_month.getNumber()) {
            passedDays = end.getDay().getNumber() -  begin.getDay().getNumber();
        } else {
            passedDays += begin.getMonth().getTotalDays() - begin.getDay().getNumber();
            passedDays += end.getDay().getNumber();
            passedMonthes += 1;

            for (int i = begin.getMonth().getNumber() + 1; i < end.getMonth().getNumber(); i++) {
                passedDays += Year.MONTHS[i - 1].getTotalDays();
                passedMonthes += 1;
            }
        }

        int[] result = { passedMonthes, passedDays };

        return result;
    }
}
