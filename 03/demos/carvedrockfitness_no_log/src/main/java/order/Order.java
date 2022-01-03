package order;

import product.Product;
import user.User;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long id;
    private User user;
    private List<Product> products;
    private LocalDateTime orderDateTime;
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(long id, User user, List<Product> products, LocalDateTime orderDateTime) {
        this.user = user;
        this.products = products;
        this.orderDateTime = orderDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
