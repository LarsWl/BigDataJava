public class Main {
    public static void main(String[] args) {
        DomesticMovie movie = new DomesticMovie("Movie", 120);
        Comedy comedy = new Comedy("Comedy", 110);

        movie.show();
        comedy.show();
    }
}