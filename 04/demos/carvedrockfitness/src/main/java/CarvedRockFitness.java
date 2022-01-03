import order.Order;
import order.OrderService;
import product.Product;
import user.User;
import util.LoggingUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class CarvedRockFitness {

    public static void main(String[] args) throws IOException {
        LoggingUtil.initLogManager();
        //some code that pretends to be a user and an order
        User user = new User(10, "Maaike", "maaike@maaike.nl", LocalDateTime.now());
        Product product = new Product(10, "jacket", 70);
        Order order = new Order(10, user, List.of(product), LocalDateTime.of(2021,11, 3, 0, 0));

        //add an order and get all orders
        OrderService orderService = new OrderService();
        orderService.addOrder(order);
        orderService.getAllOrdersByUser(new User());

        //delete order
        Order order1 = orderService.getAllOrders().get(0);
        orderService.deleteOrder(order1);

        //delete order
        orderService.deleteOrder(order1);

    }


}
