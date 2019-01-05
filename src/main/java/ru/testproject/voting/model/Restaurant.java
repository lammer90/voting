package ru.testproject.voting.model;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    /*@Where(clause = "DATEDIFF(CURDATE(), date_time) = 0")
    @WhereJoinTable(clause = "DATEDIFF(CURDATE(), date_time) = 0*/
    private Set<Dish> dishes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
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

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public Set<Vote> getVotes() {
        return votes;
    }
}
