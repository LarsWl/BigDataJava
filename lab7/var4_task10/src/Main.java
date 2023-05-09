import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Some text for testing";

        char[] text_chars = text.toCharArray();
        String best_regex = null;
        Integer max_len = null;

        for (int i = 0; i < text_chars.length; i++) {
            char seq_begin = text_chars[i];

            String regex = String.format("%c.+%c", seq_begin, seq_begin);
            Matcher matcher = Pattern.compile(regex).matcher(text);

            while (matcher.find()) {
                int len = matcher.end() - matcher.start();

                if (max_len == null || max_len < len) {
                    max_len = len;
                    best_regex = regex;
                }
            }
        }

        System.out.println(text.replaceAll(best_regex, ""));
    }
}