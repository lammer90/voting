package ru.testproject.voting.web.controller.rest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.to.RestaurantTo;
import ru.testproject.voting.web.controller.AbstractCommonController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewDetailsRestController extends AbstractCommonController {

    @Override
    @GetMapping(value = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAllRest() {
        return super.getAllRest();
    }

    @Override
    @GetMapping(value = "/results", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantTo> getAllRestWithVotesAndDishesToday() {
        return super.getAllRestWithVotesAndDishesToday();
    }

    @Override
    @GetMapping(value = "/resultsBy", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantTo> getAllRestWithVotesAndDishesByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return super.getAllRestWithVotesAndDishesByDate(date);
    }

    @Override
    @GetMapping(value = "/dishesBy/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DishTo> getAllDishesFilterByRestToday(@PathVariable("id") int restId) {
        return super.getAllDishesFilterByRestToday(restId);
    }
}
