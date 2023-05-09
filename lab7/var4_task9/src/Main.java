import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "Дамы и господа, пример текста на русском языке. Слово, Ананас";

        String cleaned_text = text.replaceAll("[^а-яА-Я ]", "");

        List<String> words = Arrays.asList(cleaned_text.split(" "));

        List<String> parsed_words = words.stream().map(word -> {
            if (word.length() < 3) {
                return word;
            } else {
                char begin = word.charAt(0);
                char end = word.charAt(word.length() - 1);

                String regex = String.format(
                        "[%c%c%c%c]",
                        Character.toLowerCase(begin),
                        Character.toUpperCase(begin),
                        Character.toLowerCase(end),
                        Character.toUpperCase(end)
                );

                String parsed = begin + word.replaceAll(regex, "") + end;

                return parsed;
            }
        }).collect(Collectors.toList());

        System.out.println(parsed_words);
    }
}