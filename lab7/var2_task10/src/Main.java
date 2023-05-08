import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regex = "([^a-zA-Z]+)";
        String text = "Current population is 134 millions, but it will be about 1000 millions";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        CharSequence max_seq = null;

        while (matcher.find()) {
            CharSequence sequence = text.subSequence(matcher.start(), matcher.end());

            if (max_seq == null || max_seq.length() < sequence.length()) {
                max_seq = sequence;
            }
        }

        System.out.print(max_seq);
    }
}