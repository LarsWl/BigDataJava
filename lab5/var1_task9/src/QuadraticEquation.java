public class QuadraticEquation {

    private double a;
    private double b;
    private double c;

    public class SolutionException extends Exception {
        String message;

        SolutionException(String message) {
            this.message = message;
        }
    };

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
    public double[] solve() throws SolutionException {
        double discriminant = b * b  - 4 * a * c;

        if (discriminant < 0) {
            throw new SolutionException(
                    String.format(
                            "koefs a=%s, b=%s, c=%s doesn't have solution",
                            a, b, c
                    )
            );

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

    public Double[] decrease_interval() {
        Double[] result;
        if (a > 0) {
            result = new Double[]{Double.NEGATIVE_INFINITY, find_extreme()};

        } else {
            result = new Double[]{find_extreme(), Double.POSITIVE_INFINITY};

        }
        return result;
    }

    public Double[] increase_interval() {
        Double[] result;
        if (a < 0) {
            result = new Double[]{Double.NEGATIVE_INFINITY, find_extreme()};

        } else {
            result = new Double[]{find_extreme(), Double.POSITIVE_INFINITY};

        }
        return result;
    }
}
