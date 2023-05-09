import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);

        double mean = list.stream().map(n -> n - 10).reduce(0, (a, b) -> a + b) / list.size();

        System.out.println(mean);
    }
}