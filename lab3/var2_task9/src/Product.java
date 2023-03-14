import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private  int id;
    private String name;
    private String upc;
    private double price;
    private String manufacturer;
    private Date expirationDate;

    public Product(int id, String name, String upc, double price, String manufacturer, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.price = price;
        this.manufacturer = manufacturer;
        this.expirationDate = expirationDate;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getUpc() { return this.upc; }
    public void setUpc(String upc) { this.upc = upc; }

    public double getPrice() { return this.price; }
    public void setPrice(double price) { this.price = price; }

    public String getManufacturer() { return this.manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public Date getExpirationDate() { return this.expirationDate; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public String toString() {
        return String.format("\nID: %s\n" +
                "Name: %s\n" +
                "UPC: %s\n" +
                "Price: %s\n" +
                "Manufacturer: %s\n" +
                "Expiration Date: %s\n",
                id, name, upc, price, manufacturer, expirationDate
        );
    }


    public static List<Product> createSample() {
        Product[] products = {
                new Product(1, "apple", "111", 1, "garden", new Date(2023, 3, 20)),
                new Product(2, "apple", "112", 1.25, "garden", new Date(2023, 3, 22)),
                new Product(3, "tomato", "113", 2, "garden+", new Date(2023, 3, 23)),
                new Product(4, "potato", "114", 1.5, "garden-", new Date(2023, 4, 15)),
                new Product(5, "potato", "115", 1.5, "garden+", new Date(2023, 4, 11)),
                new Product(6, "pepper", "116", 3, "garden+", new Date(2023, 5, 25)),
        };

        return Arrays.asList(products);
    }

    public static List<Product> getByName(List<Product> products, String name) {
        return products
                .stream()
                .filter(product -> product.getName() == name)
                .collect(Collectors.toList());
    }

    public static List<Product> getByNameAndPrice(List<Product> products, String name, double price) {
        return products
                .stream()
                .filter(product -> product.getName() == name && product.getPrice() <= price)
                .collect(Collectors.toList());
    }

    public static List<Product> getByExpirationDate(List<Product> products, Date expirationDate) {
        return products
                .stream()
                .filter(product -> product.getExpirationDate().compareTo(expirationDate) >= 0)
                .collect(Collectors.toList());
    }
}
