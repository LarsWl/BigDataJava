import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Train {

    private String destination;
    private String number;
    private Date departureTime;
    private int commonSeats;
    private int coupeSeats;
    private int reservedSeats;
    private int luxurySeats;

    public Train(
            String destination,
            String number,
            Date departureTime,
            int commonSeats,
            int coupeSeats,
            int reservedSeats,
            int luxurySeats
    ) {
        this.destination = destination;
        this.number = number;
        this.departureTime = departureTime;
        this.commonSeats = commonSeats;
        this.coupeSeats = coupeSeats;
        this.reservedSeats = reservedSeats;
        this.luxurySeats = luxurySeats;
    }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Date getDepartureTime() { return departureTime; }
    public void setDepartureTime(Date departureTime) { this.departureTime = departureTime; }

    public int getCommonSeats() { return commonSeats; }
    public void setCommonSeats(int commonSeats) { this.commonSeats = commonSeats; }

    public int getCoupeSeats() { return coupeSeats; }
    public void setCoupeSeats(int coupeSeats) { this.coupeSeats = coupeSeats; }

    public int getReservedSeats() { return reservedSeats; }
    public void setReservedSeats(int reservedSeats) { this.reservedSeats = reservedSeats; }

    public int getLuxurySeats() { return luxurySeats; }
    public void setLuxurySeats(int luxurySeats) { this.luxurySeats = luxurySeats; }

    public String toString() {
        return String.format(
                "\nDestination: %s\n" +
                        "Number: %s\n" +
                        "Departure Time: %s\n" +
                        "Common Seats: %s\n" +
                        "Coupe Seats: %s\n" +
                        "Reserved Seats: %s\n" +
                        "Luxury Seats: %s\n",
                destination, number, departureTime, commonSeats, coupeSeats, reservedSeats, luxurySeats
        );
    }

    public static List<Train> createSample() {
        Date[] dates = {
                new Date(2023, 3, 20, 17, 24, 0),
                new Date(2023, 3, 20, 19, 24, 0),
                new Date(2023, 3, 18, 13, 15, 0),
                new Date(2023, 3, 17, 17, 24, 0),
                new Date(2023, 3, 16, 17, 10, 0),
        };
        Train[] trains = {
                new Train("Moscow", "m100", dates[0], 10, 10, 10, 10),
                new Train("Moscow", "m101", dates[1], 0, 0, 10, 5),
                new Train("St. Petersburg", "s100", dates[2], 0, 1, 2, 3),
                new Train("Kazan", "k100", dates[3], 0, 10, 5, 3),
                new Train("Perm", "p100", dates[4], 5, 10, 5, 3),
        };

        return Arrays.asList(trains);
    }

    public static List<Train> getByDestination(List<Train> trains, String destination) {
        return trains
                .stream()
                .filter(train -> train.getDestination() == destination)
                .collect(Collectors.toList());
    }

    public static List<Train> getByDestinationAndTime(List<Train> trains, String destination, Date departureTime) {
        return trains
                .stream()
                .filter(train -> train.getDestination() == destination &&
                        train.getDepartureTime().compareTo(departureTime) > 0
                )
                .collect(Collectors.toList());
    }

    public static List<Train> getByDestinationAndAvailableCommonSeats(List<Train> trains, String destination) {
        return trains
                .stream()
                .filter(train -> train.getDestination() == destination && train.getCommonSeats() > 0)
                .collect(Collectors.toList());
    }
}
