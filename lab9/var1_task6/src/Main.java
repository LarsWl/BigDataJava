import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();

        collection.add("str1");
        collection.add("str2");
        collection.add("str3");
        collection.add("str2");
        collection.add("str1");

        String result = collection.stream().reduce((a, b) -> a + ";" + b).get();

        System.out.println(result);
    }
}