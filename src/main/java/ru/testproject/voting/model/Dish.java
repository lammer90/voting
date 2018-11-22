package ru.testproject.voting.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dish extends AbstractNamedEntity{
    private double price;

    private Restaurant restaurant;

    private LocalDate date;

    public Dish() {
    }

    public Dish(String name, int price, Restaurant restaurant, LocalDate date) {
        super(name);
        this.price = price;
        this.restaurant = restaurant;
        this.date = date;
    }

    public Dish(Integer id, String name, int price, Restaurant restaurant, LocalDate date) {
        super(id, name);
        this.price = price;
        this.restaurant = restaurant;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
