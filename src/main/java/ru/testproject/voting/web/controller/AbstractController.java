package ru.testproject.voting.web.controller;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.to.RestaurantTo;

import java.util.List;

public abstract class AbstractController {

    protected CommonService commonService;

    public List<Restaurant> getAllRest(){
        return commonService.getAllRest();
    }

    public List<RestaurantTo> getAllRestWithVotesAndDishesToday(){
        return commonService.getAllRestWithVotesAndDishesToday();
    }

    public List<Dish> getAllDishesFilterByRestToday(int rest_id){
        return commonService.getAllDishesFilterByRestToday(rest_id);
    }
}
