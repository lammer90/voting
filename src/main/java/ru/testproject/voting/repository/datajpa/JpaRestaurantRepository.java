package ru.testproject.voting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.testproject.voting.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface JpaRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id")int id);

    @Query("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.dishes d LEFT JOIN FETCH r.votes v WHERE v.date=:date AND d.date=:date")
    List<Restaurant> getAllWithVotesAndDishesByDate(@Param("date") LocalDate date);
}
