package order;

import user.User;
import user.UserRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());

    //get all
    public List<Order> getAllOrders() {
        LOGGER.log(Level.INFO, "Getting all the orders");
        return orderRepository.findAll();
    }

    //get by user
    public List<Order> getAllOrdersByUser(User user) {
        if (UserRepository.getDummyDataList().contains(user)) {
            LOGGER.log(Level.INFO, "Getting all orders for user id: " + user.getId() + " and username: " + user.getUserName());
            return orderRepository.findByUser(user);
        } else {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Cannot get orders for a non existing user, username: " + user.getUserName() + " id: " + user.getId());
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    }

    //post logic
    public boolean addOrder(Order order) {
        if (order.getOrderDateTime().isAfter(LocalDateTime.now())) {
            try {
                throw new Exception("Can't order in the future!");
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Placing order failed, cannot order in the future. User: " + order.getUser().getId() + " Order: " + order.getProducts());
                e.printStackTrace();
                return false;
            }
        }
        if (order.getProducts().size() < 1) {
            try {
                throw new Exception("Order must consist of at least one product!");
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.log(Level.WARNING, "Cannot get orderempyt order, username: " + order.getUser().getUserName() + " id: " + order.getUser().getId());

                return false;
            }
        }
        LOGGER.log(Level.INFO, "Saving order: " + order.getProducts() + " for user: " + order.getUser().getId());
        return orderRepository.save(order);
    }

    //delete
    public boolean deleteOrder(Order order) {
        if (order.getOrderStatus() == OrderStatus.COMPLETED) {
            try {
                throw new Exception("Can't cancel a completed order!");
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Can't cancel order with id: " + order.getId() + " because it's already completed");
                e.printStackTrace();
            }
        } else if (order.getOrderStatus() == OrderStatus.CANCELLED) {
            try {
                throw new Exception("Order was already cancelled!");
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Can't cancel order with id: " + order.getId() + " because it's already cancelled");
                e.printStackTrace();
            }
        }
        return orderRepository.remove(order);
    }

}
