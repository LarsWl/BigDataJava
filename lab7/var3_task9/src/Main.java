import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "Это очень важный и ответсвенно написаный тестовый текст, который надо будет обработать.";

        String cleaned_text = text.replaceAll("[^а-яА-Я ]", "");

        List<String> words = Arrays.asList(cleaned_text.split(" "));
        words.sort(Comparator.comparingInt(a -> a.toLowerCase().charAt(0)));

        System.out.println(words);

        for (int i = 0; i < words.size() - 1; i++) {
            System.out.print(words.get(i));

            if (words.get(i + 1).charAt(0) != words.get(i).charAt(0)) {
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
        }
        System.out.print(words.get(words.size() - 1));
    }
}