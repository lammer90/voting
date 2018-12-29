package ru.testproject.voting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.testproject.voting.model.Dish;

import java.time.LocalDate;
import java.util.List;

public interface JpaDishRepository extends JpaRepository<Dish, Integer> {

    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);

    List<Dish> findAllByDateAndRestaurant_IdOrderByName(LocalDate localDate, int rest_id);

    List<Dish> findAllByDate(LocalDate localDate);
}
