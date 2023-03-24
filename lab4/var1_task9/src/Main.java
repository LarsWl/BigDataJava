import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        List<HashMap<String, Object>> attractions = new ArrayList<>();

        HashMap<String, Object> attraction = new HashMap<>();

        attraction.put("name", "name1");
        attraction.put("price", 10.0);
        attraction.put("beginDate", new Date(2023, 12, 12, 12, 0, 0));
        attraction.put("endDate", new Date(2023, 12, 12, 18, 0, 0));

        attractions.add(attraction);

        attraction = new HashMap<>();

        attraction.put("name", "name2");
        attraction.put("price", 15.0);
        attraction.put("beginDate", new Date(2023, 12, 12, 13, 0, 0));
        attraction.put("endDate", new Date(2023, 12, 12, 17, 0, 0));

        attractions.add(attraction);

        Park park = new Park(attractions);
    }
}