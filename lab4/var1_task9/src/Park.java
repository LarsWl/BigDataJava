import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Park {

    private List<Attraction> attractions;

    private class Attraction {
        private String name;
        private double price;
        private Date beginTime;
        private Date endTime;

        public Attraction(String name, double price, Date beginTime, Date endTime) {
            this.name = name;
            this.price = price;
        }
    }

    public Park(List<HashMap<String, Object>> attractions) {
        this.attractions = attractions
                .stream()
                .map(attraction ->
                    new Attraction(
                            attraction.get("name").toString(),
                            (double) attraction.get("price"),
                            (Date) attraction.get("beginTime"),
                            (Date) attraction.get("endTime")
                    )
                )
                .collect(Collectors.toList());
    }
}
