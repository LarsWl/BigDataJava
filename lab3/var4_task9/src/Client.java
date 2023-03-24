import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Client {
    private int id;
    private String name;

    private boolean blocked;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
        this.blocked = false;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return String.format("Id: %s, Name: %s, Blocked: %s", id, name, blocked);
    }

    public void block() {
        this.blocked = true;
    }

    public boolean isBlocked() {
        return blocked;
    }

    static void printList(List<Client> clients) {
        IntStream.range(0, clients.size()).forEach(
                i -> System.out.println((i + 1) + ". " + clients.get(i).toString())
        );
    }

    static List<Client> candidatesForBlock(List<Client> clients, List<Payment> payments) {
        List<Integer> clientIds = payments
                .stream()
                .filter(payment -> !payment.getPaid())
                .map(payment -> payment.getClientId())
                .collect(Collectors.toList());

        return clients
                .stream()
                .filter(client -> clientIds.contains(client.getId()) && !client.isBlocked())
                .collect(Collectors.toList());
    }
}
