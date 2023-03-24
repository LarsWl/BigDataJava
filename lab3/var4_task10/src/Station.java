import java.util.List;
import java.util.stream.IntStream;

public class Station {

    private int id;
    private String name;
    private boolean last;

    public Station(int id, String name, boolean last) {
        this.id = id;
        this.name = name;
        this.last = last;
    }

    static void printList(List<Station> stations) {
        IntStream.range(0, stations.size()).forEach(
                i -> System.out.println((i + 1) + ". " + stations.get(i).toString())
        );
    }

    public String toString() {
        return String.format("ID: %s, Name: %s, Last: %s", id, name, last);
    }

    public boolean isLast() {
        return last;
    }

    public int getId() {
        return id;
    }
}
