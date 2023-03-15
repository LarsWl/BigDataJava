import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Train> trains = Train.createSample();

        System.out.printf("Generated sample:\n%s\n", trains);
        System.out.printf("Trains to Moscow:\n%s\n", Train.getByDestination(trains, "Moscow"));
        System.out.printf(
                "Trains to Moscow after 18:00:\n%s\n",
                Train.getByDestinationAndTime(trains, "Moscow", new Date(2023, 3, 20, 18, 0 ,0))
        );
        System.out.printf("Trains to Moscow:\n%s\n", Train.getByDestinationAndAvailableCommonSeats(trains, "Moscow"));
    }
}