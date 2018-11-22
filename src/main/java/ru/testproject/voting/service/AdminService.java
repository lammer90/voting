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

    void deleteUser(int id);

    List<User> getAllUsers();

    Dish addDish(Dish dish);

    Dish getDish(int id);

    void deleteDish(int id);
}
