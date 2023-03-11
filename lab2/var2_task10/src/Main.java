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
    }
}