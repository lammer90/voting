package ru.testproject.voting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.repository.DishRepository;
import ru.testproject.voting.repository.RestaurantRepository;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ru.testproject.voting.util.VerifyUtil.chekObject;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<DishTo> getAllDishesFilterByRestToday(int restId) {
        chekObject(restaurantRepository.get(restId), "No restaurant found");
        return dishRepository.getAllFilterRestAndDate(restId, LocalDate.now()).stream()
                .map(DishTo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Restaurant> getAllRest() {
        return restaurantRepository.getAll();
    }

    @Override
    public List<RestaurantTo> getAllRestWithVotesAndDishesToday() {
        List<Restaurant> restaurants = restaurantRepository.getAllWithVotesAndDishesByDate(LocalDate.now());

        return restaurants.stream()
                .map(r -> new RestaurantTo(r.getId(), r.getName(), r.getVotes().size(), r.getDishes())).collect(Collectors.toList());
    }
}
