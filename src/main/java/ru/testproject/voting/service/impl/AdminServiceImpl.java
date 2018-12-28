package ru.testproject.voting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.User;
import ru.testproject.voting.repository.DishRepository;
import ru.testproject.voting.repository.RestaurantRepository;
import ru.testproject.voting.repository.UserRepository;
import ru.testproject.voting.service.AdminService;

import java.time.LocalDate;
import java.util.List;

import static ru.testproject.voting.util.VerifyUtil.checkEmptyString;
import static ru.testproject.voting.util.VerifyUtil.checkNotFound;
import static ru.testproject.voting.util.VerifyUtil.chekObject;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Restaurant addRestaurant(String restName) {
        checkEmptyString(restName, "The name of the restaurant should not be empty");
        return restaurantRepository.save(new Restaurant(restName));
    }

    @Override
    public void deleteRestaurant(int id) {
        checkNotFound(restaurantRepository.delete(id), "No restaurant found");
    }

    @Override
    public User addUser(User user) {
        Assert.notNull(user, "User must not be null");
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        Assert.notNull(user, "User must not be null");
        chekObject(userRepository.save(user), "No user found");
    }

    @Override
    public User getUser(int id) {
        return chekObject(userRepository.get(id), "No user found");
    }

    @Override
    public void deleteUser(int id) {
        checkNotFound(userRepository.delete(id), "No user found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public Dish addDish(Dish dish) {
        Assert.notNull(dish, "Dish must not be null");
        return dishRepository.save(dish);
    }

    @Override
    public void updateDish(Dish dish) {
        Assert.notNull(dish, "Dish must not be null");
        chekObject(dishRepository.save(dish), "No dish found");
    }

    @Override
    public Dish getDish(int id) {
        return chekObject(dishRepository.get(id), "No dish found");
    }

    @Override
    public void deleteDish(int id) {
        checkNotFound(dishRepository.delete(id), "No dish found");
    }
}
