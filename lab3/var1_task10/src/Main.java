public class Main {
    public static void main(String[] args) {
        boolean[][] source_matrix = {
                { true, true, false },
                { true, true, false },
                { true, true, false },
                { true, true, false }
        };

        BoolMatrix matrix_1 = new BoolMatrix(source_matrix);
        BoolMatrix matrix_2 = new BoolMatrix(4, 3);

        BoolMatrix matrix_3 = matrix_1
                .logic_multiply(matrix_2.invert())
                .logic_add(matrix_1);

        matrix_3.print();

        System.out.printf("Count: %d", matrix_3.count());
    }
}