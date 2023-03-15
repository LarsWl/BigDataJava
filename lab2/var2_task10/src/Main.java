import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");

        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        in.close();

        int max_matrix_value = n;
        int min_matrix_value = -n;

        double matrix_max = Double.NEGATIVE_INFINITY;
        Set<Integer> columns_for_delete = new HashSet<Integer>();
        Set<Integer> rows_for_delete = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int elem = (int)(Math.random() * (max_matrix_value - min_matrix_value) + min_matrix_value);

                matrix[i][j] = elem;

                if (matrix[i][j] > matrix_max) {
                    matrix_max = matrix[i][j];

                    columns_for_delete.clear();
                    columns_for_delete.add(j);

                    rows_for_delete.clear();
                    rows_for_delete.add(i);
                } else if (matrix[i][j] == matrix_max) {
                    columns_for_delete.add(j);
                    rows_for_delete.add(i);
                }
            }
        }

        System.out.println("Source matrix:");
        print_matrix(matrix);

        System.out.printf("Matrix Max: %s\n", matrix_max);

        int[][] new_matrix = new int[n - rows_for_delete.size()][n - columns_for_delete.size()];

        int new_matrix_i = 0;

        for (int i = 0; i < n; i++) {
            if (rows_for_delete.contains(i)) continue;

            int new_matrix_j = 0;
            for (int j = 0; j < n; j++) {
                if (columns_for_delete.contains(j)) continue;

                new_matrix[new_matrix_i][new_matrix_j] = matrix[i][j];

                new_matrix_j++;
            }
            new_matrix_i++;
        }

        System.out.println("New matrix:");
        print_matrix(new_matrix);
    }

    public static void print_matrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s  ", matrix[i][j]);
            }

            System.out.println();
        }
    }
}