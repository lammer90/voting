package ru.testproject.voting.model;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import java.util.Set;

public class Restaurant extends AbstractNamedEntity{
    /*@Where(clause = "DATEDIFF(CURDATE(), date_time) = 0")
    @WhereJoinTable(clause = "DATEDIFF(CURDATE(), date_time) = 0*/
    private Set<Dish> dishes;

    /*@Where(clause = "DATEDIFF(CURDATE(), date_time) = 0")
    @WhereJoinTable(clause = "DATEDIFF(CURDATE(), date_time) = 0")*/
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
