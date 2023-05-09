import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(7);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);

        int result = list.stream().filter(n -> n % 7 == 0).reduce(0, (a, b) -> a + b);

        System.out.println(result);
    }
}