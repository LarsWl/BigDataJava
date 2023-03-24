import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {

    private List<MovieTheater> movieTheaters;

    private class MovieTheater {
        private String address;
        private HashMap<String, List<Date>>  movieSessions;

        public MovieTheater(String address, HashMap<String, List<Date>>  movieSessions) {
            this.address = address;
            this.movieSessions = movieSessions;
        }
    }

    public Cinema(List<HashMap<String, Object>> movieTheaters) {
        this.movieTheaters = movieTheaters
                .stream()
                .map(theater -> new MovieTheater(
                        theater.get("address").toString(),
                        (HashMap<String, List<Date>>) theater.get("movieSessions")
                ))
                .collect(Collectors.toList());
    }
}
