package ru.testproject.voting.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.testproject.voting.model.AbstractNamedEntity;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.HasId;
import ru.testproject.voting.model.Vote;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RestaurantTo implements HasId {
    private Integer id;

    private String name;

    private int countOfVotes;

    private Set<DishTo> dishes;

    public RestaurantTo() {
    }

    public RestaurantTo(Integer id, String name, int countOfVotes) {
        this.id = id;
        this.name = name;
        this.countOfVotes = countOfVotes;
    }

    public RestaurantTo(Integer id, String name, Set<DishTo> dishes, int countOfVotes) {
        this.id = id;
        this.name = name;
        this.countOfVotes = countOfVotes;
        this.dishes = dishes;
    }

    public RestaurantTo(Integer id, String name, int countOfVotes, Set<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.countOfVotes = countOfVotes;
        this.dishes = new HashSet<>();
        dishes.forEach(d -> this.dishes.add(new DishTo(d)));
    }

    public int getCountOfVotes() {
        return countOfVotes;
    }

    public void setCountOfVotes(int countOfVotes) {
        this.countOfVotes = countOfVotes;
    }

    public Set<DishTo> getDishes() {
        return dishes;
    }

    public void setDishes(Set<DishTo> dishes) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTo that = (RestaurantTo) o;
        return id == that.id &&
                countOfVotes == that.countOfVotes &&
                Objects.equals(name, that.name) &&
                Objects.equals(dishes, that.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countOfVotes, dishes);
    }
}
