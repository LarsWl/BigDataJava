import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> args_list = Arrays.asList(args);
        Collections.reverse(args_list);

        System.out.println(args_list);
    }
}