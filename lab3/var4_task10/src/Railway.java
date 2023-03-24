import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Railway {
    private List<Station> stations;
    private List<Client> clients;
    private List<Train> trains;
    private List<Application> applications;
    private List<Bill> bills;

    public Railway() {
        this.stations = new LinkedList<>();
        this.clients = new LinkedList<>();
        this.trains = new LinkedList<>();
        this.applications = new LinkedList<>();
        this.bills = new LinkedList<>();
    }

    public void commandCreateNewStation() {
        System.out.println("Enter station name");
        String name = App.getStringValue();

        System.out.println("Enter 1 if station is last and 2 if its intermediate");
        double choice = App.getNumericValue();

        int stationId = stations.size() + 1;

        Station station = new Station(stationId, name, choice == 1);

        stations.add(station);

        System.out.println("Current stations:");
        Station.printList(stations);
    }

    public void commandCreateNewTrain() {
        System.out.println("Enter train number");
        String number = App.getStringValue();

        String dateFormat = "dd/MM/yyyy HH:mm";
        SimpleDateFormat parser = new SimpleDateFormat(dateFormat);

        System.out.println("Enter departure date in format:" + dateFormat);
        Date departureDate = null;
        try {
            departureDate = parser.parse(App.getStringValue());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter price");
        double price = App.getNumericValue();

        Station chosenStation;
        List<Integer> chosenStationIds = new LinkedList<Integer>();

        do {
            List<Station> leftStations = stations
                    .stream()
                    .filter(station -> !(chosenStationIds.contains(station.getId())))
                    .collect(Collectors.toList());
            System.out.println("Chose station till last:");
            Station.printList(leftStations);

            int stationChoice = App.getCommand();

            chosenStation = stations.get(stationChoice - 1);
            chosenStationIds.add(chosenStation.getId());
        } while (!chosenStation.isLast());

        int trainId = trains.size() + 1;

        Train train = new Train(trainId, number, chosenStationIds, price, departureDate);

        trains.add(train);

        System.out.println("Current trains");
        Train.printList(trains);
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

    public void commandCreateApplication(int clientId) {
        System.out.println("Chose station");
        Station.printList(stations);

        int stationChoice = App.getCommand();
        Station station = stations.get(stationChoice - 1);

        String dateFormat = "dd/MM/yyyy HH:mm";
        SimpleDateFormat parser = new SimpleDateFormat(dateFormat);

        System.out.println("Enter departure date in format: " + dateFormat);
        Date departureDate = null;
        try {
            departureDate = parser.parse(App.getStringValue());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int applicationId = applications.size() + 1;
        Application application = new Application(applicationId, clientId, station, departureDate);
        applications.add(application);

        List<Train> possibleTrains = application.possibleTrains(trains);

        if (possibleTrains.size() == 0) {
            System.out.println("There are no possible trains");

            return;
        }

        System.out.println("Chose from possible trains");
        Train.printList(possibleTrains);

        int trainChoice = App.getCommand();
        Train train = possibleTrains.get(trainChoice - 1);

        application.setTrain(train);
        Bill bill = new Bill(bills.size() + 1, application);
        bills.add(bill);

        System.out.println("Your current application:");
        Application.printList(Application.selectByClientId(clientId, applications));
    }

    public void commandPayBill(int clientId) {
        List<Bill> unpaidBills = Bill.selectClientUnpaidBills(clientId, bills);

        if (unpaidBills.size() == 0) {
            System.out.println("There are no unpaid bills");
            return;
        }

        System.out.println("Your unpaid bills:");
        Bill.printList(unpaidBills);

        int billChoice = App.getCommand();

        unpaidBills.get(billChoice - 1).pay();
    }
}
