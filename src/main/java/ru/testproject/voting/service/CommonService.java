package ru.testproject.voting.service;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;

public interface CommonService {
    List<Dish> getAllDishesFilterByRestToday(int rest_id);

    List<Restaurant> getAllRest();

    List<RestaurantTo> getAllRestWithVotesAndDishesToday();
}
