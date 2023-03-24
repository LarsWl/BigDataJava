import java.util.List;
import java.util.stream.IntStream;

public class Item {

    private int id;
    private String name;
    private double price;

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    static void printList(List<Item> items) {
        IntStream.range(0, items.size()).forEach(
                i -> System.out.println((i + 1) + ". " + items.get(i).toString())
        );
    }

    public String toString() {
        return String.format("ID: %s, Name: %s, Price: %s", id, name, price);
    }
}
