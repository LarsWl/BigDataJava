import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Payment {

    private int id;
    private int orderId;
    private int clientId;
    private PaymentStatus status;

    private boolean paid;

    static enum PaymentStatus {
        NEW,
        COMPLETED
    }

    public Payment(int id, int orderId, int clientId) {
        this.id = id;
        this.orderId = orderId;
        this.clientId = clientId;
        this.status = PaymentStatus.NEW;
        this.paid = false;
    }

    public boolean getPaid() { return paid; }
    public int getOrderId() { return orderId; }
    public int getClientId() { return clientId; }

    public void complete() {
        this.status = PaymentStatus.COMPLETED;
    }
    public void pay() {
        this.paid = true;
    }


    public String toString() {
        return String.format("Payment ID: %s, Order ID: %s, Status: %s, Paid: %s", id, orderId, status, paid);
    }

    static List<Payment> newPayments(List<Payment> payments) {
        return payments
                .stream()
                .filter(payment -> payment.status == PaymentStatus.NEW)
                .collect(Collectors.toList());
    }

    static void printList(List<Payment> payments) {
        IntStream.range(0, payments.size()).forEach(
                i -> System.out.println((i + 1) + ". " + payments.get(i).toString())
        );
    }

    static Payment findByOrderId(List<Payment> payments, int orderId) {
        return payments
                .stream()
                .filter(payment -> payment.getOrderId() == orderId)
                .findFirst()
                .get();
    }
}
