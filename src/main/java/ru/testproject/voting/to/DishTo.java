package ru.testproject.voting.to;

import ru.testproject.voting.model.AbstractNamedEntity;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.HasId;
import ru.testproject.voting.model.Restaurant;

import java.util.Objects;

public class DishTo implements HasId {
    private Integer id;

    private String name;

    private int price;

    private int restaurant;

    public DishTo() {
    }

    public DishTo(String name, int price, int restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public DishTo(Integer id, String name, int price, int restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public DishTo(Dish dish) {
        this.id = dish.getId();
        this.name = dish.getName();
        this.price = dish.getPrice();
        this.restaurant = dish.getRestaurant().getId();
    }

    public int getPrice() {
        return price;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestaurantId() {
        return restaurant;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurant = restaurantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishTo dishTo = (DishTo) o;
        return id == dishTo.id &&
                price == dishTo.price &&
                restaurant == dishTo.restaurant &&
                Objects.equals(name, dishTo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, restaurant);
    }
}
