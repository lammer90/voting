package ru.testproject.voting.service;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;

public interface CommonService {
    List<DishTo> getAllDishesFilterByRestToday(int rest_id);

    List<Restaurant> getAllRest();

    default List<RestaurantTo> getAllRestWithVotesAndDishesToday(){
        return getAllRestWithVotesAndDishesByDate(LocalDate.now());
    }

    List<RestaurantTo> getAllRestWithVotesAndDishesByDate(LocalDate date);
}
