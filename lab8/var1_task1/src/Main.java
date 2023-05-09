import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        int commands_number = 10;

        for (int i = 0; i < commands_number; i++) {
            int command = getRandomInt(1, 3);
            int amount = getRandomInt(100, 10000);

            BankCommand bankCommand = new BankCommand(bank, command, amount);

            bankCommand.run();
        }
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}