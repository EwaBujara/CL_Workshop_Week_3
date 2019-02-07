package pl.coderslab.model;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Solution {

    private int id;
    private User user;
    private Exercise exercise;
    private String content;
    private LocalDate created;

    public Solution() {
    }

    public Solution(int id, User user, Exercise exercise) {
        this.id = id;
        this.user = user;
        this.exercise = exercise;
    }

    public Solution(int id, User user, Exercise exercise, String content, LocalDate created) {
        this.id = id;
        this.user = user;
        this.exercise = exercise;
        this.content = content;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
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
}