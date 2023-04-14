import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path input_path = Paths.get("input.txt");
        String text = "";
        try {
            BufferedReader reader = Files.newBufferedReader(input_path);

            while (reader.ready()) {
                text += reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
            return;
        }

        Set<String> words = Arrays
                .stream(text.split("[ .,:\\n]"))
                .map(word -> word.toLowerCase())
                .collect(Collectors.toSet());


        System.out.println(words);
    }
}