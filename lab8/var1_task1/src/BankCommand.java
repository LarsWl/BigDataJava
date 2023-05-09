public class BankCommand implements Runnable {
    Bank bank;
    int command;
    int amount;

    BankCommand(Bank bank, int command, int amount) {
        this.bank = bank;
        this.command = command;
        this.amount = amount;
    }
    public void run() {
        if (this.command == 1) {
            System.out.printf("Running command: increase. Amount: %d\n", this.amount);
            bank.increase(amount);
        } else if (this.command == 2){
            System.out.printf("Running command: decrease. Amount: %d\n", this.amount);
            bank.decrease(amount);
        } else {
            System.out.printf("Unknown command: %s", this.command);
        }
    }
}
