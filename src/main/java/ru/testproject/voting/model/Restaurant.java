package ru.testproject.voting.model;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import java.util.Set;

public class Restaurant extends AbstractNamedEntity{
    /*@Where(clause = "restaurant_id = r.id")
    @WhereJoinTable(clause = "restaurant_id = r.id")*/
    private Set<Dish> dishes;

    /*@Where(clause = "restaurant_id = r.id")
    @WhereJoinTable(clause = "restaurant_id = r.id")*/
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
