package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private UserGroup userGroup;

    public User() {
    }

    public User(String name) {

        setUsername(name);
    }

    public User(String username, String password) {
        this.username = username;
        this.setPassword(password);
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(String username, String password, String email, UserGroup userGroup) {
        this.username = username;
        this.setPassword(password);
        this.email = email;
        this.userGroup = userGroup;
    }

    //constructor for elements from db
    public User(int id, String username, String password, String email, UserGroup userGroup) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userGroup = userGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, userGroup);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}
