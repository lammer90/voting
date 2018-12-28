package ru.testproject.voting.service;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.User;

import java.util.List;

public interface AdminService {

    Restaurant addRestaurant(Restaurant restaurant);

    void deleteRestaurant(int id);

    User addUser(User user);

    void updateUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    List<User> getAllUsers();

    Dish addDish(Dish dish);

    void updateDish(Dish dish);

    Dish getDish(int id);

    void deleteDish(int id);
}
