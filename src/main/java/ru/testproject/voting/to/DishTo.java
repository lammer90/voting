package ru.testproject.voting.to;

import ru.testproject.voting.model.AbstractNamedEntity;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;

public class DishTo extends AbstractNamedEntity {
    private double price;
    private Restaurant restaurant;

    public DishTo() {
    }

    public DishTo(String name, double price, Restaurant restaurant) {
        super(name);
        this.price = price;
        this.restaurant = restaurant;
    }

    public DishTo(Integer id, String name, double price, Restaurant restaurant) {
        super(id, name);
        this.price = price;
        this.restaurant = restaurant;
    }

    public DishTo(Dish dish) {
        super(dish.getId(), dish.getName());
        this.price = dish.getPrice();
        this.restaurant = dish.getRestaurant();
    }

    public double getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
