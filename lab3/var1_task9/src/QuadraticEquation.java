public class QuadraticEquation {

    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(double a) {
        this.a = a;
        this.b = 0;
        this.c = 0;
    }

    public QuadraticEquation(double a, double b) {
        this.a = a;
        this.b = b;
        this.c = 0;
    }

    public double[] solve() {
        double discriminant = b * b  - 4 * a * c;

        if (discriminant < 0) {
            System.out.printf("Equation doesn't have real solutions");

            return (new double[0]);
        } else if (discriminant == 0) {
            double[] solution = { -b / (2 * a) };

            return solution;
        } else {
            double[] solution = {
                    (-b + Math.sqrt(discriminant)) / (2 * a),
                    (-b - Math.sqrt(discriminant)) / (2 * a)
            };

            return solution;
        }
    }

    public double find_extreme() {
        return -b / (2 * a);
    }
}
