import java.util.regex.Pattern;

public class Bank {
    int balance;

    public Bank() {
        this.balance = 0;
    }

    public synchronized void increase(int amount) {
        this.balance += amount;

        print_balance();
    }

    public synchronized void decrease(int amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds");
        } else {
            this.balance -= amount;
        }

        print_balance();
    }

    private void print_balance() {
        System.out.printf("Current balance: %s\n", this.balance);
    }
}
