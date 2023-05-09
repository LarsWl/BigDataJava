import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Дамы и господа, пример текста на русском языке";

        String cleaned_text = text.replaceAll("[^а-яА-Я ]", "");

        List<String> words = Arrays.asList(cleaned_text.split(" "));

        words.sort((a, b) -> {
            if (calc_word_ratio(a) > calc_word_ratio(b)) {
                return 1;
            } else {
                return -1;
            }
        });

        System.out.println(words);
    }

    public static double calc_word_ratio(String word) {
        String vowel_regex = "[аиоеяуыюАИОЕЯУЫЮ]";

        Matcher vowel_matcher = Pattern.compile(vowel_regex).matcher(word);

        double vowel_count = 0;
        while (vowel_matcher.find()) vowel_count += 1;

        return (vowel_count / word.length());
    }
}