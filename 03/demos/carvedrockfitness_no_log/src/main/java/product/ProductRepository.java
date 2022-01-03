package product;

import order.Order;
import user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    public static List<Product> getDummyDataList() {
        Product product1 = new Product(1, "liquid chalk", 10);
        Product product2 = new Product(2, "climbing boots", 100);
        Product product3 = new Product(3, "backpack", 60);

        Product[] products = {product1, product2, product3};
        return new ArrayList<>(Arrays.asList(products));
    }
}
