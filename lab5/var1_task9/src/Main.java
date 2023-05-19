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
        Path input_path = Paths.get("koefs.txt");
        BufferedReader reader;
        List<QuadraticEquation> arr = new LinkedList<>();

        try {
            reader = Files.newBufferedReader(input_path);

            while(reader.ready()) {
                List<Double> koefs = Arrays.stream(reader
                        .readLine()
                        .split(" "))
                        .map(koef -> Double.parseDouble(koef))
                        .collect(Collectors.toList());

                QuadraticEquation equation = new QuadraticEquation(
                        koefs.get(0),
                        koefs.get(1),
                        koefs.get(2)
                );

                arr.add(equation);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Cannot read input file");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Each row should contain three numbers");
            return;
        } catch (Exception e) {
            System.out.printf("Unexpected error: %s\n", e);
            return;
        }

        double min_solution;
        try {
            min_solution = arr.get(0).solve()[0];
        } catch (QuadraticEquation.SolutionException  e) {
            System.out.println(e.message);

            return;
        }

        double max_solution = min_solution;

        try {
            for (int i = 0; i < arr.size(); i++) {
                System.out.printf("%d: ", i);
                double[] solutions = arr.get(i).solve();

                for (int j = 0; j < solutions.length; j++) {
                    System.out.printf("%s ", solutions[j]);

                    if (solutions[j] > max_solution) {
                        max_solution = solutions[j];
                    }

                    if (solutions[j] < min_solution) {
                        min_solution = solutions[j];
                    }
                }

                System.out.printf("\n");
            }
        } catch (QuadraticEquation.SolutionException  e) {
            System.out.println(e.message);

            return;
        } catch (Exception e) {
            System.out.printf("Unexpected error: %s\n", e);
            return;
        }

        Path output_path = Paths.get("result.txt");
        try {
            BufferedWriter writer = Files.newBufferedWriter(output_path);

            writer.write(String.format("Max solution: %s\n", max_solution));
            writer.write(String.format("Min solution: %s\n", min_solution));

            Double[] increase_interval = arr.get(0).increase_interval();
            Double[] decrease_interval = arr.get(0).decrease_interval();

            writer.write(String.format("Extreme point for first: %s\n", arr.get(0).find_extreme()));
            writer.write(
                    String.format(
                            "Increase interval for first: (%s, %s)\n",
                            increase_interval[0], increase_interval[1]
                    )
            );
            writer.write(
                    String.format(
                            "Decrease interval for first: (%s, %s)\n",
                            decrease_interval[0], decrease_interval[1]
                    )
            );

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