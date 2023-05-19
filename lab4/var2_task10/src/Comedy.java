public class Comedy extends DomesticMovie {
    public Comedy(String name, int duration) {
        super(name, duration);
    }

    public void show() {
        System.out.printf("Showing domestic comedy %s for %s minutes\n", name, duration);
    }
}
