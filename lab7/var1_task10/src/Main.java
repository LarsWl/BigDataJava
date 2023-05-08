import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String special_chars_regex = "([*\\.|()\\[\\]])";

        System.out.println("Enter start symbol");
        String start = in.nextLine();
        System.out.println("Enter end symbol");
        String end = in.nextLine();

        String start_reg = Pattern
                .compile(special_chars_regex)
                .matcher(start)
                .replaceFirst("\\\\$1");

        String end_reg = Pattern
                .compile(special_chars_regex)
                .matcher(end)
                .replaceFirst("\\\\$1");

        String regex = String.format("%s(.+)%s", start_reg, end_reg);

        System.out.println(regex);

        String text = String.format("There is %ssome%s te*xt*", start, end);

        System.out.println("Source text:");
        System.out.println(text);

        System.out.println("Result text:");
        System.out.println(deleteGroup(regex, text));
    }

    public static String deleteGroup(String regex, String source) {
        Matcher m = Pattern.compile(regex).matcher(source);
        m.find();

        return new StringBuilder(source)
                .replace(m.start(1), m.end(1),"")
                .toString();
    }
}