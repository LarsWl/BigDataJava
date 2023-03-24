import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Order {
    private int id;
    private List<Integer> itemIds;
    private int clientId;

    public Order(int id, int clientId, List<Integer> itemIds) {
        this.id = id;
        this.clientId = clientId;
        this.itemIds = itemIds;
    }

    public int getId() { return id; }

    public String toString() {
        return String.format("Order ID: %s, Client ID: %s, items: %s", id, clientId, itemIds);
    }
    static void printList(List<Order> orders) {
        IntStream.range(0, orders.size()).forEach(
                i -> System.out.println((i + 1) + ". " + orders.get(i).toString())
        );
    }

    static List<Order> unpaidClientOrders(int clientId, List<Order> orders, List<Payment> payments) {
        List<Integer> orderIds = payments
                .stream()
                .filter(payment -> payment.getClientId() == clientId && !payment.getPaid())
                .map(payment -> payment.getOrderId())
                .collect(Collectors.toList());

        return orders
                .stream()
                .filter(order -> orderIds.contains(order.getId()))
                .collect(Collectors.toList());
    }
}
