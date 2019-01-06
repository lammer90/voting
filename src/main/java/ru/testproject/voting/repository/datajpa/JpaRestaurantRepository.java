package ru.testproject.voting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.testproject.voting.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface JpaRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id")int id);

    @Query("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.dishes d LEFT JOIN FETCH r.votes v WHERE (d.date=:date OR d.date is null) AND (v.date=:date OR v.date is null) ORDER BY r.name, d.name")
    List<Restaurant> getAllWithVotesAndDishesByDate(@Param("date") LocalDate date);

    @Query("SELECT r FROM Restaurant r ORDER BY r.name")
    List<Restaurant> findAllOrdered();
}
