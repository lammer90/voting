package ru.testproject.voting.to;

import ru.testproject.voting.model.AbstractNamedEntity;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;

public class DishTo extends AbstractNamedEntity {
    private int price;
    private int restaurantId;

    public DishTo() {
    }

    public DishTo(String name, int price, int restaurantId) {
        super(name);
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public DishTo(Integer id, String name, int price, int restaurantId) {
        super(id, name);
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public DishTo(Dish dish) {
        super(dish.getId(), dish.getName());
        this.price = dish.getPrice();
        this.restaurantId = dish.getRestaurant().getId();
    }

    public int getPrice() {
        return price;
    }

    public int getRestaurant() {
        return restaurantId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRestaurant(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
