package ru.testproject.voting.model;

import org.hibernate.validator.constraints.Range;
import ru.testproject.voting.to.DishTo;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity{

    @Column(name = "price")
    @Digits(integer = 20, fraction = 2)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @NotNull
    private Restaurant restaurant;

    @Column(name = "date_time")
    @NotNull
    private LocalDate date;

    public Dish() {
    }

    public Dish(String name, double price, Restaurant restaurant, LocalDate date) {
        super(name);
        this.price = price;
        this.restaurant = restaurant;
        this.date = date;
    }

    public Dish(Integer id, String name, double price, Restaurant restaurant, LocalDate date) {
        super(id, name);
        this.price = price;
        this.restaurant = restaurant;
        this.date = date;
    }

    public Dish(Dish dish) {
        super(dish.getId(), dish.getName());
        this.price = dish.getPrice();
        this.restaurant = dish.getRestaurant();
        this.date = LocalDate.now();
    }

    public Dish(DishTo dishTo) {
        super(dishTo.getId(), dishTo.getName());
        this.price = dishTo.getPrice();
        this.restaurant = dishTo.getRestaurant();
        this.date = LocalDate.now();
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
