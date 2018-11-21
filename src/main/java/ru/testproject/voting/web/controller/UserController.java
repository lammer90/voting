package ru.testproject.voting.web.controller;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.repository.DishRepository;
import ru.testproject.voting.repository.RestaurantRepository;
import ru.testproject.voting.repository.VoteRepository;
import ru.testproject.voting.to.RestaurantTo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserController {
    private RestaurantRepository restaurantRepository;

    private DishRepository dishRepository;

    private VoteRepository voteRepository;



    public List<Dish> getAllDishFilterByRestAndDate(){
        return dishRepository.getAllFilterRestAndDate();
    }

    public List<Restaurant> getAllRest() {
        return restaurantRepository.getAll();
    }

    public List<RestaurantTo> getAllRestWithVotesAndDishes(){
        List<Restaurant> restaurants = restaurantRepository.getAllWithVotesAndDishes();

        Map<Restaurant, Integer> map = restaurants.stream()
                .collect(Collectors.groupingBy(r -> r, Collectors.summingInt(r -> 1)));

        return restaurants.stream()
                .map(r -> new RestaurantTo(r.getId(), r.getName(), map.get(r), r.getDishes())).collect(Collectors.toList());
    }
}
