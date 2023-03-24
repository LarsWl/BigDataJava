import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<HashMap<String, Object>> movieTheaters = new ArrayList<>();

        HashMap<String, Object> theater = new HashMap<>();
        HashMap<String, List<Date>> sessions = new HashMap<>();

        List<Date> avatarDates = new ArrayList<>();

        avatarDates.add(new Date(2023, 3, 12, 12, 0, 0));
        avatarDates.add(new Date(2023, 4, 12, 12, 0, 0));

        sessions.put("Avatar", avatarDates);

        theater.put("address", "some_address");
        theater.put("movieSessions", sessions);

        movieTheaters.add(theater);

        Cinema cinema = new Cinema(movieTheaters);
    }
}