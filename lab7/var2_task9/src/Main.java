import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String word_regex = "\\b";
        String text = "Nature's first green is gold,\n" +
                "Her hardest hue to hold.\n" +
                "Her early leaf's a flower;\n" +
                "But only so an hour.\n";

        List<String> words = List.of(text.split(word_regex));
        Set<Character> characters = new HashSet<>();

        char[] text_chars = text.toCharArray();
        for (int i = 0; i < text_chars.length; i++) {
            Character character = new Character(text_chars[i]);

            System.out.print(character);
            characters.add(character);
        }

        Set<Character> presented = characters.stream().filter(character -> {
            AtomicReference<Boolean> char_present = new AtomicReference<>(true);

            words.forEach(word -> {
                Set<Character> word_characters = new HashSet<>();
                char[] word_chars = word.toCharArray();

                for (int i = 0; i < word_chars.length; i++) {
                    Character word_character = new Character(word_chars[i]);
                    word_characters.add(word_character);
                }

                if (!word_characters.contains(character)) {
                    char_present.set(false);
                }
            });

            return char_present.get();
        }).collect(Collectors.toSet());

        System.out.println("Results:");
        System.out.println(presented);
    }
}