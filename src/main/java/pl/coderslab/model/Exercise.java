package pl.coderslab.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exercise {

    private int id;
    private String name;
    private String content;
    private LocalDate created;
    private User user;

    public Exercise() {
    }

    public Exercise(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    //constructor for database elements
    public Exercise(int id, String name, String content, LocalDate created, User user) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.created = created;
        this.user = user;

    }
    public Exercise(String name, String content, LocalDate created, User user) {
        this.name = name;
        this.content = content;
        this.created = created;
        this.user = user;

    }

    public Exercise(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
