import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Developer: Egor Shmorgun");

        Date assignement_begin_date = new Date(2023, 2, 17);
        Date assignment_end_date = new Date();

        System.out.printf("Assignment begin date: %s \n", assignement_begin_date);
        System.out.printf("Assignment end date: %s \n", assignment_end_date);

        int k = Integer.valueOf(args[0]);

        int interval_number = 0;

        if (isBetween(k, -10 * k, 0)) {
            interval_number = 1;
        } else if (isBetween(k, 0, 5)) {
            interval_number = 2;
        } else if (isBetween(k, 5, 10)) {
            interval_number = 3;
        } else if (isBetween(k, 10, 10 * k)) {
            interval_number = 4;
        }

        switch (interval_number) {
            case 0:
                System.out.println("k doesn't belong to intervals");
                break;
            case 1:
                System.out.println("k in (-10k, 0]");
                break;
            case 2:
                System.out.println("k in (0, 5]");
                break;
            case 3:
                System.out.println("k in (5, 10]");
                break;
            case 4:
                System.out.println("k in (10, 10k]");
                break;
        }

    }

    private static boolean isBetween(int value, int begin, int end) {
        return value > begin && value <= end;
    }
}
