package ru.testproject.voting.repository;

import ru.testproject.voting.model.Dish;

import java.time.LocalDateTime;
import java.util.List;

public interface DishRepository {
    Dish save(Dish dish);

    boolean delete(int id);

    Dish get(int id);

    List<Dish> getAll();

    List<Dish> getAllFilterRestAndDate(int rest_id, LocalDateTime date);
}
