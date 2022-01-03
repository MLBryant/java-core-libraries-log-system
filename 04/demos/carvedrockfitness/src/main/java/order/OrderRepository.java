package order;

import product.Product;
import product.ProductRepository;
import user.User;
import user.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRepository {
    private List<Order> orderList = getDummyDataList();

    public List<Order> findAll() {
        return orderList;
    }

    public List<Order> findByUser(User user) {
        List<Order> userOrderlist = new ArrayList<>();
        for (Order o : orderList) {
            if (o.getUser().equals(user)) {
                userOrderlist.add(o);
            }
        }
        return userOrderlist;
    }

    public boolean save(Order order) {
        order.setId(orderList.get(orderList.size() - 1).getId() + 1);
        return orderList.add(order);
    }

    public boolean remove(Order order) {
        if(orderList.contains(order)){
            order.setOrderStatus(OrderStatus.CANCELLED);
            return true;
        } else {
            return false;
        }
    }

    public static List<Order> getDummyDataList() {

        UserRepository userRepository = new UserRepository();
        List<User> userList = userRepository.getUserList();
        List<Product> productList = ProductRepository.getDummyDataList();

        Order order1 = new Order(1, userList.get(0), productList.subList(0, 1), LocalDateTime.now());
        Order order2 = new Order(2, userList.get(0), productList.subList(1, 1), LocalDateTime.now());
        Order order3 = new Order(3, userList.get(1), productList.subList(2, 2), LocalDateTime.now());
        Order order4 = new Order(4, userList.get(1), productList.subList(1, 2), LocalDateTime.now());
        Order order5 = new Order(5, userList.get(2), productList.subList(2, 2), LocalDateTime.now());
        Order order6 = new Order(6, userList.get(2), productList.subList(0, 2), LocalDateTime.now());

        Order[] orders = {order1, order2, order3, order4, order5, order6};
        List<Order> orderList = new ArrayList<>(Arrays.asList(orders));
        return orderList;
    }


}
