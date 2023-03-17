public class Month {
    private int totalDays;
    private String name;
    private int number;

    public int getNumber() { return number; }
    public int getTotalDays() { return totalDays; }

    public boolean equals(Month month) {
        return this.number == month.number &&
                this.name.equals(month.name) &&
                this.totalDays == month.totalDays;
    }

    public String toString() {
        return String.format("\nName: %s\n" +
                "Number of month: %s\n" +
                "Total days: %s\n",
                name, number, totalDays
        );
    }

    @Override
    public int hashCode() {
        return number * totalDays * name.hashCode();
    }

    public Month(String name, int number, int totalDays) {
        this.name = name;
        this.number = number;
        this.totalDays = totalDays;
    }
}
