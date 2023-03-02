import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = in.nextInt();

        List<Integer> numbers = new ArrayList<>();

        System.out.printf("Enter %d numbers:\n", n);

        for (int i = 0; i < n; i++) {
            Integer number = in.nextInt();

            numbers.add(number);
        }
        System.out.printf("Source numbers list: %s \n", numbers);

        boolean is_sorted;
        do {
            is_sorted = true;

            for (int i = 0; i < n - 1; i++) {
                if (abs(numbers.get(i)) < abs(numbers.get(i + 1))) {
                    int tmp = numbers.get(i);

                    numbers.set(i, numbers.get(i + 1));
                    numbers.set(i + 1, tmp);

                    is_sorted = false;
                }
            }
        } while (!is_sorted);

        System.out.printf("Sorted numbers list: %s \n", numbers);
    }
}