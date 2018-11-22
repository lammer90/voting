package ru.testproject.voting.repository.impl;

import org.springframework.stereotype.Repository;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.repository.DishRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {
    @Override
    public Dish save(Dish dish) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Dish get(int id) {
        return null;
    }

    @Override
    public List<Dish> getAll() {
        return null;
    }

    @Override
    public List<Dish> getAllFilterRestAndDate(int rest_id, LocalDate date) {
        return null;
    }
}
