import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");

        int n = in.nextInt();
        double[][] matrix = new double[n][n];

        in.close();

        int max_matrix_value = n;
        int min_matrix_value = -n;

        double matrix_sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double elem = Math.random() * (max_matrix_value - min_matrix_value) + min_matrix_value;

                matrix[i][j] = Math.round(elem * 100.0) / 100.0;;

                matrix_sum += elem;
            }
        }

        System.out.println("Source matrix:");
        print_matrix(matrix, n);

        double matrix_mean = matrix_sum / (n * n);
        matrix_mean = Math.round(matrix_mean * 100.0) / 100.0;

        System.out.printf("Matrix Mean: \n%s\n", matrix_mean);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double new_elem = Math.round((matrix[i][j] - matrix_mean) * 100.0) / 100.0;
                matrix[i][j] = new_elem;
            }
        }

        System.out.println("New matrix:");
        print_matrix(matrix, n);
    }

    public static void print_matrix(double[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }

            System.out.println();
        }
    }
}