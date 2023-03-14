import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Product.createSample();

        System.out.printf("Generated Sample:\n%s\n", products);
        System.out.printf("Apple products:\n%s\n", Product.getByName(products, "apple"));
        System.out.printf("Cheap apple products:\n%s\n", Product.getByNameAndPrice(products, "apple", 1));
        System.out.printf("Long living products:\n%s\n", Product.getByExpirationDate(products, new Date(2023, 4, 1)));
    }
}