import java.io.IOException;
import java.util.Scanner;

public class App {
    public App() {
        this.in = new Scanner(System.in);
    }

    @Override
    protected void finalize() {
        try {
            in.close();
        } catch (Exception e){
            return;
        }
    }

    public void run() {
        App.initScanner();

        Actor actor = new Actor(Actor.Role.CLIENT);
        Railway railway = new Railway();
        boolean actor_chosen = false;

        while(true) {
            App.commandPrompt();

            if (!actor_chosen) {
                print_chose_actor_prompt();

                int command = App.getCommand();

                if (command == 1) {
                    actor.setRole(Actor.Role.CLIENT);
                    actor_chosen = true;
                } else if (command == 2) {
                    actor.setRole(Actor.Role.ADMIN);
                    actor_chosen = true;
                } else if (command == 3) {
                    break;
                } else {
                    App.wrongCommandPrompt();
                }
            } else {
                actor.printCommandPrompt();

                int command = App.getCommand();

                boolean exited = actor.executeCommand(command, railway);

                if (exited) { actor_chosen = false; }
            }
        }

        App.closeScanner();
    }

    public static void print_chose_actor_prompt() {
        System.out.print("Who are you?: \n" +
                "1: Client \n" +
                "2. Admin \n" +
                "3. Exit\n" +
                "Your choice: "
        );
    }

    static public int getCommand() {
        int command = in.nextInt();
        in.nextLine();

        return command;
    }

    static public String getStringValue() {
        return in.nextLine();
    }

    static public double getNumericValue() {
        return in.nextDouble();
    }

    static public void commandPrompt() {
        System.out.println("Enter command:");
    }

    static public void wrongCommandPrompt() {
        System.out.println("Wrong command");
    }

    private static Scanner in;

    public static void initScanner() { in = new Scanner(System.in); }
    public static void closeScanner() { in.close(); }
}
