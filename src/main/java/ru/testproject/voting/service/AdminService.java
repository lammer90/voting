package ru.testproject.voting.service;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.User;
import ru.testproject.voting.to.DishTo;

import java.time.LocalDate;
import java.util.List;

public interface AdminService {

    Restaurant addRestaurant(String restName);

    void deleteRestaurant(int id);

    User addUser(User user);

    void updateUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    List<User> getAllUsers();

    Dish addDish(DishTo dishTo);

    void updateDish(DishTo dishTo);

    Dish getDish(int id);

    default List<Dish> getAllDishToday() {
        return getAllDishByDate(LocalDate.now());
    }

    List<Dish> getAllDishByDate(LocalDate localDate);

    void deleteDish(int id);
}
