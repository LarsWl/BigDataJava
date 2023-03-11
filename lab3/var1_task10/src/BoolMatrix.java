public class BoolMatrix {

    private boolean[][] matrix;
    private int n;
    private int m;

    public BoolMatrix(boolean[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.m = matrix[0].length;
    }

    public BoolMatrix(int n) {
        this.matrix = new boolean[n][n];
        this.n = n;
        this.m = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = false;
            }
        }
    }

    public BoolMatrix(int n, int m) {
        this.matrix = new boolean[n][m];
        this.n = n;
        this.m = m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.matrix[i][j] = false;
            }
        }
    }

    public BoolMatrix invert() {
        boolean[][] inverted = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                inverted[i][j] = !matrix[i][j];
            }
        }

        return new BoolMatrix(inverted);
    }

    public BoolMatrix logic_add(BoolMatrix second) {
        boolean[][] result = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[i][j] || second.matrix[i][j];
            }
        }

        return new BoolMatrix(result);
    }

    public BoolMatrix logic_multiply(BoolMatrix second) {
        boolean[][] result = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[i][j] && second.matrix[i][j];
            }
        }

        return new BoolMatrix(result);
    }

    public int count() {
        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]) counter++;
            }
        }

        return counter;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }

            System.out.printf("\n");
        }


    }
}
