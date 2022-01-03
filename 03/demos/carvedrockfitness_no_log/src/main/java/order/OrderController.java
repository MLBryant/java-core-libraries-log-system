package order;

import user.User;

import java.util.List;

public class OrderController {
    private static final OrderService orderService = new OrderService();

    //get all endpoint
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    //get by user
    public List<Order> getAllOrdersByUser(User user) {
        return orderService.getAllOrdersByUser(user);
    }

    //post endpoint
    public boolean addOrder(Order order) {
        return orderService.addOrder(order);
    }

    //delete
    public boolean deleteOrder(Order order) {
        return orderService.deleteOrder(order);
    }

}
