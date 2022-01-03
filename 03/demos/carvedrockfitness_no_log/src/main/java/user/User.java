package user;

import java.time.LocalDateTime;

public class User {
    private long id;
    private String userName;
    private String email;
    private LocalDateTime created;

    public User() {
    }

    public User(long id, String userName, String email, LocalDateTime created) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString(){
        return User.class.getName() + " - name: " + userName + ", id: " + id + ", email: " + email;
    }
}
