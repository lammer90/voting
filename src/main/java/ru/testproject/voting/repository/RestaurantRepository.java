package ru.testproject.voting.repository;

import ru.testproject.voting.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();

    List<Restaurant> getAllWithVotesAndDishesByDate(LocalDate date);

    Restaurant getReference(int restId);
}
