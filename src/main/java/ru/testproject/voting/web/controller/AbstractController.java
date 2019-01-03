package ru.testproject.voting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractController {

    @Autowired
    protected CommonService commonService;

    public List<Restaurant> getAllRest(){
        return commonService.getAllRest();
    }

    public List<RestaurantTo> getAllRestWithVotesAndDishesToday(){
        return commonService.getAllRestWithVotesAndDishesToday();
    }

    public List<Dish> getAllDishesFilterByRestToday(int restId){
        return commonService.getAllDishesFilterByRestToday(restId);
    }
}
