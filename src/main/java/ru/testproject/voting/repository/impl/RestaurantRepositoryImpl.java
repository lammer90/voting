package ru.testproject.voting.repository.impl;

import org.springframework.stereotype.Repository;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    @Override
    public Restaurant save(Restaurant restaurant) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Restaurant get(int id) {
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    public List<Restaurant> getAllWithVotesAndDishesByDate(LocalDate date) {
        return null;
    }
}
