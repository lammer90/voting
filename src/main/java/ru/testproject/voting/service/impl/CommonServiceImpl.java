package ru.testproject.voting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.repository.impl.DishRepositoryImpl;
import ru.testproject.voting.repository.impl.RestaurantRepositoryImpl;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private RestaurantRepositoryImpl restaurantRepository;

    @Autowired
    private DishRepositoryImpl dishRepository;

    @Override
    public List<Dish> getAllDishesFilterByRestToday(int rest_id) {
        return dishRepository.getAllFilterRestAndDate(rest_id, LocalDate.now());
    }

    @Override
    public List<Restaurant> getAllRest() {
        return restaurantRepository.getAll();
    }

    @Override
    public List<RestaurantTo> getAllRestWithVotesAndDishesToday() {
        List<Restaurant> restaurants = restaurantRepository.getAllWithVotesAndDishesByDate(LocalDate.now());

        Map<Restaurant, Integer> map = restaurants.stream()
                .collect(Collectors.groupingBy(r -> r, Collectors.summingInt(r -> 1)));

        return restaurants.stream()
                .map(r -> new RestaurantTo(r.getId(), r.getName(), map.get(r), r.getDishes())).collect(Collectors.toList());
    }
}
