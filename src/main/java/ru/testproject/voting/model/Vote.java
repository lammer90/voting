package ru.testproject.voting.model;

import java.time.LocalDateTime;

public class Vote extends AbstractBaseEntity{
    private LocalDateTime dateTime;

    private Restaurant restaurant;

    private User user;

    public Vote() {
    }

    public Vote(LocalDateTime dateTime, Restaurant restaurant, User user) {
        this.dateTime = dateTime;
        this.restaurant = restaurant;
        this.user = user;
    }

    public Vote(Integer id, LocalDateTime dateTime, Restaurant restaurant, User user) {
        super(id);
        this.dateTime = dateTime;
        this.restaurant = restaurant;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "dateTime=" + dateTime +
                ", restaurant=" + restaurant +
                ", user=" + user +
                ", id=" + id +
                '}';
    }
}
