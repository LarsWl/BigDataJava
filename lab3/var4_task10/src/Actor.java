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

    public boolean executeCommand(int command, Railway railway) {
        if (role == Role.ADMIN) {
            return executeAdminCommand(command, railway);
        } else {
            return executeClientCommand(command, railway);
        }
    }

    private boolean executeAdminCommand(int command, Railway railway) {
        if (command == 1) {
            railway.commandCreateNewStation();
        } else if (command == 2) {
            railway.commandCreateNewTrain();
        } else if (command == 3) {
            return true;
        } else {
            App.wrongCommandPrompt();
        }

        return false;
    }

    private boolean executeClientCommand(int command, Railway railway) {
        if (identified) {
            if (command == 1) {
                railway.commandCreateApplication(clientId);
            } else if (command == 2) {
                railway.commandPayBill(clientId);
            } else if (command == 3) {
                this.identified = false;

                return true;
            }
        } else {
            executeIdentificationCommand(command, railway);
        }

        return false;
    }

    private void printAdminCommandPrompt() {
        System.out.print("1. Add station\n" +
                "2. Add train\n" +
                "3. Chose another role\n" +
                "Your choice: "
        );
    }

    private void printClientCommandPrompt() {
        if (identified) {
            System.out.print("1. Create Application\n" +
                    "2. Pay Bill\n" +
                    "3. Chose another role\n" +
                    "Your choice: ");
        } else {
            System.out.print("1. Chose client\n" +
                    "2. Create client\n" +
                    "Your choice: ");
        }
    }

    private void executeIdentificationCommand(int command, Railway railway) {
        if (command == 1) {
            Client client = railway.commandChoseClient();

            this.clientId = client.getId();
            this.identified = true;
        } else if (command == 2) {
            Client client = railway.commandCreateClient();

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
