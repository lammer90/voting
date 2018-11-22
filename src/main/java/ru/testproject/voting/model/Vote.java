package ru.testproject.voting.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vote extends AbstractBaseEntity{
    private LocalDate date;

    private Restaurant restaurant;

    private User user;

    public Vote() {
    }

    public Vote(LocalDate date, Restaurant restaurant, User user) {
        this.date = date;
        this.restaurant = restaurant;
        this.user = user;
    }

    public Vote(Integer id, LocalDate date, Restaurant restaurant, User user) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "dateTime=" + date +
                ", restaurant=" + restaurant +
                ", user=" + user +
                ", id=" + id +
                '}';
    }
}
