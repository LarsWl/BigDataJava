public class DomesticMovie implements Movie {
    protected String name;
    protected int duration;

    public DomesticMovie() {
        this.name = "";
        this.duration = 0;
    }

    public DomesticMovie(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public void show() {
        System.out.printf("Showing domestic movie %s for %s minutes\n", name, duration);
    }
}
