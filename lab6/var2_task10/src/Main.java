public class Main {
    public static void main(String[] args) {
        double[][] cars = {
                { 1, 10 },
                { 2, 15 },
                { 3, 9 },
                { 4, 16 },
                { 5, 11 }
        };

        int N = cars.length;

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (cars[i][0] < cars[j][0] && cars[i][1] > cars[j][1]) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}