import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();

        collection.add("str1");
        collection.add("str2");
        collection.add("str3");
        collection.add("str2");
        collection.add("str1");

        Set<String> strings = new HashSet<>();

        collection.stream().forEach(str -> strings.add(str));

        List<String> unique = strings.stream().collect(Collectors.toList());

        System.out.println(unique);
    }
}
