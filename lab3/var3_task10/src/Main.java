public class Main {
    public static void main(String[] args) {
        Day day = new Day(17, 30);

        System.out.printf("Day:\n%s\n", day);
        System.out.printf("Part of day: %s\n", day.partOfDay());
    }
}