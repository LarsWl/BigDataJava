import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    private int id;
    private int clientId;

    private Date departureDate;
    private Train train;
    private Station station;

    public Application(int id, int clientId, Station station, Date departureDate) {
        this.id = id;
        this.clientId = clientId;
        this.departureDate = departureDate;
        this.train = null;
        this.station = station;
    }

    public void setTrain(Train train) { this.train = train; }
    public Train getTrain() { return train; }
    public int getClientId() { return clientId; }

    public List<Train> possibleTrains(List<Train> trains) {
        return trains
                .stream()
                .filter(train -> train.getStationIds().contains(station.getId()) && departureDate.compareTo(train.getDepartureDate()) < 0)
                .collect(Collectors.toList());
    }

    public String toString() {
        return String.format("Id: %s\n" +
                "Departure Date: %s\n" +
                "Station: %s\n" +
                "Train: %s\n",
                id, departureDate, station, train);

    }

    public static void printList(List<Application> applications) {
        IntStream.range(0, applications.size()).forEach(
                i -> System.out.println((i + 1) + ". " + applications.get(i).toString())
        );
    }

    public static List<Application> selectByClientId(int clientId, List<Application> applications) {
        return applications
                .stream()
                .filter(application -> application.clientId == clientId)
                .collect(Collectors.toList());
    }
}
