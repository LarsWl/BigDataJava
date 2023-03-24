import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bill {
    private int id;
    private Application application;

    private boolean paid;
    private double amount;

    public Bill(int id, Application application) {
        this.id = id;
        this.application = application;
        this.paid = false;
        this.amount = application.getTrain().getPrice();
    }

    public static List<Bill> selectClientUnpaidBills(int clientId, List<Bill> bills) {
        return bills
                .stream()
                .filter(bill -> !bill.paid && bill.application.getClientId() == clientId)
                .collect(Collectors.toList());
    }

    public void pay() { this.paid = true; }

    public String toString() {
        return String.format("Id: %s, Amount: %s, Paid: %s", id, amount, paid);
    }

    static void printList(List<Bill> bills) {
        IntStream.range(0, bills.size()).forEach(
                i -> System.out.println((i + 1) + ". " + bills.get(i).toString())
        );
    }
}
