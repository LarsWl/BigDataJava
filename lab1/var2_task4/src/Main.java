import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = in.nextInt();

        List<Integer> numbers = new ArrayList<>();

        System.out.printf("Enter %d numbers:\n", n);

        for(int i = 0; i < n; i = i + 1) {
            Integer number = in.nextInt();

            numbers.add(number);
        }
        System.out.printf("Source numbers list: %s \n", numbers);

        List<Integer> suitable_numbers = numbers
                .stream()
                .filter(arg -> (arg % 5 == 0) && (arg % 7 == 0))
                .collect(Collectors.toList());


        System.out.printf("Filtered numbers list: %s \n", suitable_numbers);
    }
}