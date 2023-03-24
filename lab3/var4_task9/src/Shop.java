import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Shop {
    private List<Item> items;
    private List<Payment> payments;

    private List<Order> orders;

    private List<Client> clients;

    public Shop() {
        this.items = new LinkedList<Item>();
        this.payments = new LinkedList<Payment>();
        this.orders = new LinkedList<Order>();
        this.clients = new LinkedList<Client>();
    }

    public void commandCreateNewItem() {
        System.out.println("Enter item name");
        String name = App.getStringValue();

        System.out.println("Enter item price");
        double price = App.getNumericValue();

        int itemId = items.size() + 1;

        Item item = new Item(itemId, name, price);

        items.add(item);

        System.out.println("Current items:");
        Item.printList(items);
    }

    public void commandCompletePayment() {
        App.commandPrompt();

        List<Payment> newPayments = Payment.newPayments(payments);
        if (newPayments.size() == 0) {
            System.out.println("There are no new payments");

            return;
        }

        // Print new payments list for user choice
        Payment.printList(newPayments);
        int paymentChoice = App.getCommand();
        newPayments.get(paymentChoice - 1).complete();

        System.out.println("Payment completed!");
    }

    public Client commandChoseClient() {
        System.out.println("Chose client: ");
        Client.printList(clients);

        int clientChoice = App.getCommand();

        return clients.get(clientChoice - 1);
    }

    public Client commandCreateClient() {
        System.out.println("Enter client name: ");

        String clientName = App.getStringValue();

        int clientId = clients.size() + 1;
        Client client = new Client(clientId, clientName);

        clients.add(client);

        return client;
    }

    public void commandCreateOrder(int clientId) {
        List<Integer> orderItems = new LinkedList<Integer>();

        int command = 0;
        int end_command = items.size() + 1;

        do {
            System.out.println("Chose item or create order");

            Item.printList(items);
            System.out.println(end_command + ". Create order");

            command = App.getCommand();

            if (command >= 0 && command < end_command) {
                orderItems.add(command);
            }
        } while (command != end_command);

        int orderId = orders.size() + 1;
        int paymentId = payments.size() + 1;

        Order order = new Order(orderId, clientId, orderItems);
        Payment payment = new Payment(paymentId, orderId, clientId);

        orders.add(order);
        payments.add(payment);

        System.out.println("Your orders: ");
        Order.printList(orders);
    }

    public void commandPayOrder(int clientId) {
        List<Order> unpaidOrders = Order.unpaidClientOrders(clientId, orders, payments);

        System.out.println("Your unpaid orders, chose order to pay:");
        Order.printList(unpaidOrders);

        int orderChoice = App.getCommand();

        Order unpaidOrder = unpaidOrders.get(orderChoice - 1);
        Payment payment = Payment.findByOrderId(payments, unpaidOrder.getId());

        payment.pay();
    }

    public void commandAddClientToBlacklist() {
        List<Client> bad_clients = Client.candidatesForBlock(clients, payments);

        if (bad_clients.size() == 0) {
            System.out.println("There are no candidates for block");

            return;
        }

        System.out.println("Candidates for block");
        Client.printList(bad_clients);

        int clientChoice = App.getCommand();

        bad_clients.get(clientChoice - 1).block();
    }
}
