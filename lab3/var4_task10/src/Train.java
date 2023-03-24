import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class Train {
    public int id;
    public String number;
    public List<Integer> stationIds;
    public double price;
    public Date departureDate;

    public Train(int id, String number, List<Integer> stationIds, double price, Date departureDate) {
        this.id = id;
        this.number = number;
        this.stationIds = stationIds;
        this.price = price;
        this.departureDate = departureDate;
    }

    public List<Integer> getStationIds() { return this.stationIds; }
    public Date getDepartureDate() { return this.departureDate; }
    public double getPrice() { return price; }

    static void printList(List<Train> trains) {
        IntStream.range(0, trains.size()).forEach(
                i -> System.out.println((i + 1) + ". " + trains.get(i).toString())
        );
    }

    public String toString() {
        return String.format(
                "ID: %s, Number: %s, price: %s, Departure Date: %s, Stations: %s",
                id, number, price, departureDate, stationIds
        );
    }
}
