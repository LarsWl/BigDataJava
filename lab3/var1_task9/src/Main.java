public class Main {
    public static void main(String[] args) {

        QuadraticEquation[] arr = {
                new QuadraticEquation(1, 0, 0),
                new QuadraticEquation(-2, 3),
                new QuadraticEquation(0.4, 0, 5),
                new QuadraticEquation(-0.4, 0.5, 5)
        };

        double min_solution = arr[0].solve()[0];
        double max_solution = min_solution;

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d: ", i);
            double[] solutions = arr[i].solve();

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

        System.out.printf("Max solution: %s\n", max_solution);
        System.out.printf("Min solution: %s\n", min_solution);
    }
}