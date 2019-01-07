package ru.testproject.voting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.User;
import ru.testproject.voting.repository.DishRepository;
import ru.testproject.voting.repository.RestaurantRepository;
import ru.testproject.voting.repository.UserRepository;
import ru.testproject.voting.service.AdminService;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.util.exception.TimeLimitException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ru.testproject.voting.util.VerifyUtil.*;

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

    @Transactional
    @Override
    public Dish addDish(DishTo dishTo) {
        Restaurant restaurantRef = chekObject(restaurantRepository.getReference(dishTo.getRestaurant()), "No restaurant found");
        Assert.notNull(dishTo, "Dish must not be null");
        Dish newDish = new Dish(dishTo);
        newDish.setRestaurant(restaurantRef);
        return dishRepository.save(newDish);
    }

    @Transactional
    @Override
    public void updateDish(DishTo dishTo) {
        Restaurant restaurantRef = chekObject(restaurantRepository.getReference(dishTo.getRestaurant()), "No restaurant found");
        Assert.notNull(dishTo, "Dish must not be null");
        verifyDishDate(dishTo.getId());
        Dish newDish = new Dish(dishTo);
        newDish.setRestaurant(restaurantRef);
        chekObject(dishRepository.save(newDish), "No dish found");
    }

    @Override
    public List<DishTo> getAllDishByDate(LocalDate localDate) {
        return dishRepository.getAllFilterDate(localDate).stream().map(DishTo::new).collect(Collectors.toList());
    }

    @Override
    public void deleteDish(int id) {
        verifyDishDate(id);
        checkNotFound(dishRepository.delete(id), "No dish found");
    }

    @Override
    public DishTo getDish(int id) {
        //verifyDishDate(id);
        return new DishTo(chekObject(dishRepository.get(id), "No dish found"));
    }

    private void verifyDishDate(int id){
        Dish dish = chekObject(dishRepository.get(id), "No dish found");
        if (!dish.getDate().equals(LocalDate.now())){
            throw new TimeLimitException("You can not change the old dishes");
        }
    }
}
