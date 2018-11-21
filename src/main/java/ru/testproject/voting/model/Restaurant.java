package ru.testproject.voting.model;

import java.util.Set;

public class Restaurant extends AbstractNamedEntity{
    private Set<Dish> dishes;

    private Set<Vote> votes;

    public Restaurant() {
    }

    public Restaurant(String name) {
        super(name);
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public Set<Vote> getVotes() {
        return votes;
    }
}
