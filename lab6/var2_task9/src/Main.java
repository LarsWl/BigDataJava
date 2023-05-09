import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> sizes_stack = new Stack<>();

        int[][] matrix = {
                { 1, 1, 2, 2, 2 }, // 0
                { 1, 1, 2, 2, 2 }, // 1
                { 3, 3, 2, 2, 2 }, // 2
                { 4, 6, 2, 2, 2 }, // 3
                { 4, 6, 6, 6, 6 }, // 3
                { 4, 6, 6, 6, 6 }, // 3
        };
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (isSectorPresent(matrix, i, j)) {
                    int size = i * j;
                    if (sizes_stack.empty() || sizes_stack.lastElement() < size) {
                        sizes_stack.push(size);
                    }
                }
            }
        }

        System.out.println(sizes_stack.pop());
    }

    public static boolean isSectorPresent(int[][] matrix, int rows, int cols) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i <= n - rows; i++) {
            for (int j = 0; j <= m - cols; j++) {
                boolean needed_sector = true;
                int sector_val = matrix[i][j];

                for (int k = 0; k < rows; k++) {
                    for (int l = 0; l < cols; l++) {
                        if (matrix[i + k][j + l] != sector_val) {
                            needed_sector = false;
                            break;
                        }
                    }
                    if (!needed_sector) break;
                }

                if (needed_sector) return true;
            }
        }

        return false;
    }
}