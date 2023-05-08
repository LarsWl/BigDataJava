import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        String regex = String.format("(\\b[b-df-hj-np-tv-z][a-z]{%s})\\b", n - 1);
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        String text = "There is VERY nice arch in center.";
        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.replaceAll(""));
    }
}