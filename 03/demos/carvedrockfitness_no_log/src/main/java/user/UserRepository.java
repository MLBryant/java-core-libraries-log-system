package user;

import product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private static List<User> userList = getDummyDataList();

    public List<User> getUserList() {
        return userList;
    }

    public static List<User> getDummyDataList() {
        User user1 = new User(1, "maaike", "maaike@dummyemail.com", LocalDateTime.now());
        User user2 = new User(2, "lina", "lina@dummyemail.com", LocalDateTime.now());
        User user3 = new User(3, "john", "john@dummyemail.com", LocalDateTime.now());

        User[] users = {user1, user2, user3};
        return new ArrayList<>(Arrays.asList(users));
    }
}
