package ru.testproject.voting.to;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Vote;

import java.util.Set;

public class RestaurantTo {
    private Integer id;

    private String name;

    private int countOfVotes;

    private Set<Dish> dishes;

    public RestaurantTo(Integer id, String name, int countOfVotes, Set<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.countOfVotes = countOfVotes;
        this.dishes = dishes;
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

    public int getCountOfVotes() {
        return countOfVotes;
    }

    public void setCountOfVotes(int countOfVotes) {
        this.countOfVotes = countOfVotes;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countOfVotes=" + countOfVotes +
                ", dishes=" + dishes +
                '}';
    }
}
