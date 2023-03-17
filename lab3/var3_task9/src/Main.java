public class Main {
    public static void main(String[] args) {
      Year begin = new Year(2023, 1, 12);
      Year end = new Year(2023, 2, 24);

      System.out.println(begin);

      int[] periods = Year.calcPeriod(begin, end);

      System.out.printf("Day of week: %s\n", begin.dayOfWeek());
      System.out.printf("Passed months and days: %s, %s\n", periods[0], periods[1]);
    }
}