import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path input_path = Paths.get("input.txt");
        BufferedReader reader;
        List<BoolMatrix> arr = new LinkedList<>();

        try {
            reader = Files.newBufferedReader(input_path);

            while(reader.ready()) {
                List<Integer> sizes = Arrays.stream(reader
                                .readLine()
                                .split(" "))
                        .map(koef -> Integer.parseInt(koef))
                        .collect(Collectors.toList());

                Boolean[][] matrix = new Boolean[sizes.get(0)][sizes.get(1)];

                for (int i = 0; i < sizes.get(0); i++) {
                    List<Boolean> row = Arrays.stream(reader
                                    .readLine()
                                    .split(" "))
                            .map(koef -> Boolean.parseBoolean(koef))
                            .collect(Collectors.toList());

                    matrix[i] = row.toArray(new Boolean[0]);
                }

                BoolMatrix boolMatrix = new BoolMatrix(matrix);

                arr.add(boolMatrix);
            }

            reader.close();
        } catch (IOException e) {
            System.out.printf("Cannot read input file. Error: %s\n", e);
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Each row should contain three numbers");
            return;
        } catch (Exception e) {
            System.out.printf("Unexpected error: %s\n", e);
            return;
        }

        BoolMatrix matrix_4 = arr.get(0)
                .logic_multiply(arr.get(1))
                .logic_add(arr.get(2).invert());

        Path output_path = Paths.get("result.txt");
        try {
            BufferedWriter writer = Files.newBufferedWriter(output_path);

            writer.write("Operations result:\n");
            writer.write(matrix_4.toString());

            writer.write(String.format("Count: %d\n", matrix_4.count()));
            writer.write("Sort second matrix:\n");

            arr.get(1).sort();
            writer.write(arr.get(1).toString());

            writer.close();
        } catch (IOException e) {
            System.out.println("Error while writing results to file");

            return;
        } catch (Exception e) {
            System.out.printf("Unexpected error: %s\n", e);
            return;
        }
    }
}