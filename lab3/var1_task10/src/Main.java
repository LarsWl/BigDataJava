public class Main {
    public static void main(String[] args) {
        boolean[][] source_matrix_1 = {
                { true, true, false },
                { true, true, false },
                { false, true, false },
                { true, true, false }
        };

        boolean[][] source_matrix_2 = {
                { true, true, false },
                { false, false, true },
                { false, true, false },
                { true, true, true }
        };


        BoolMatrix matrix_1 = new BoolMatrix(source_matrix_1);
        BoolMatrix matrix_2 = new BoolMatrix(source_matrix_2);
        BoolMatrix matrix_3 = new BoolMatrix(4, 3);

        BoolMatrix matrix_4 = matrix_1
                .logic_multiply(matrix_2.invert())
                .logic_add(matrix_3);

        System.out.println("Operations result:");
        matrix_4.print();
        System.out.printf("Count: %d\n", matrix_4.count());

        System.out.println("Sort second matrix:");
        matrix_2.sort();
        matrix_2.print();
    }
}