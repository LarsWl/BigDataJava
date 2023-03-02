import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Source args list: %s \n", Arrays.toString(args));

        List<Integer> suitable_args_list = Stream.
                of(args)
                .map(Integer::valueOf)
                .filter(arg -> (arg % 5 == 0) && (arg % 7 == 0))
                .collect(Collectors.toList());


        System.out.printf("Filtered args list: %s \n", suitable_args_list);
    }
}