import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Client {
    private int id;
    private String name;
    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return String.format("Id: %s, Name: %s", id, name);
    }

    static void printList(List<Client> clients) {
        IntStream.range(0, clients.size()).forEach(
                i -> System.out.println((i + 1) + ". " + clients.get(i).toString())
        );
    }
}
