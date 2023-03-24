public class Actor {

    private Role role;
    private boolean identified;
    private int clientId;

    public Actor(Role role) {
        this.role = role;
        this.identified = false;
    };

    public void setRole(Role role) { this.role = role; }

    public void printCommandPrompt() {
        if (role == Role.ADMIN) {
            printAdminCommandPrompt();
        } else {
            printClientCommandPrompt();
        }
    }

    public boolean executeCommand(int command, Shop shop) {
        if (role == Role.ADMIN) {
            return executeAdminCommand(command, shop);
        } else {
            return executeClientCommand(command, shop);
        }
    }

    private boolean executeAdminCommand(int command, Shop shop) {
        if (command == 1) {
            shop.commandCreateNewItem();
        } else if (command == 2) {
            shop.commandCompletePayment();
        } else if (command == 3) {
            shop.commandAddClientToBlacklist();
        } else if (command == 4) {
            return true;
        } else {
            App.wrongCommandPrompt();
        }

        return false;
    }

    private boolean executeClientCommand(int command, Shop shop) {
        if (identified) {
            if (command == 1) {
                shop.commandCreateOrder(clientId);
            } else if (command == 2) {
                shop.commandPayOrder(clientId);
            } else if (command == 3) {
                this.identified = false;

                return true;
            }
        } else {
            executeIdentificationCommand(command, shop);
        }

        return false;
    }

    private void printAdminCommandPrompt() {
        System.out.print("1. Add item\n" +
                "2. Register payment\n" +
                "3. Add client to black list\n" +
                "4. Chose another role\n" +
                "Your choice: "
        );
    }

    private void printClientCommandPrompt() {
        if (identified) {
            System.out.print("1. Create order\n" +
                    "2. Pay order\n" +
                    "3. Chose another role\n" +
                    "Your choice: ");
        } else {
            System.out.print("1. Chose client\n" +
                    "2. Create client\n" +
                    "Your choice: ");
        }
    }

    private void executeIdentificationCommand(int command, Shop shop) {
        if (command == 1) {
            Client client = shop.commandChoseClient();

            this.clientId = client.getId();
            this.identified = true;
        } else if (command == 2) {
            Client client = shop.commandCreateClient();

            this.clientId = client.getId();
            this.identified = true;
        } else {
            App.wrongCommandPrompt();
        }
    }

    static public enum Role {
        CLIENT,
        ADMIN
    }
}
