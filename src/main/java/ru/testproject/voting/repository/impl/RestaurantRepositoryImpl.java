package ru.testproject.voting.repository.impl;

import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.repository.RestaurantRepository;

import java.util.List;

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
    public List<Restaurant> getAllWithVotesAndDishes() {
        return null;
    }
}
