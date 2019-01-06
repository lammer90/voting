package ru.testproject.voting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.User;
import ru.testproject.voting.service.AdminService;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.util.VerifyUtil;

import java.util.List;

public abstract class AdminController extends AbstractCommonController {

    @Autowired
    private AdminService adminService;

    public Restaurant addRestaurant(String restName) {
        return adminService.addRestaurant(restName);
    }

    public void deleteRestaurant(int id) {
        adminService.deleteRestaurant(id);
    }

    public User addUser(User user) {
        return adminService.addUser(user);
    }

    public void updateUser(User user, int id) {
        VerifyUtil.assureIdConsistent(user, id);
        adminService.updateUser(user);
    }

    public User getUser(int id){
        return adminService.getUser(id);
    }

    public void deleteUser(int id) {
        adminService.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    public Dish addDishToday(DishTo dishTo) {
        return adminService.addDish(dishTo);
    }

    public void updateDishToday(DishTo dishTo, int id) {
        VerifyUtil.assureIdConsistent(dishTo, id);
        adminService.updateDish(dishTo);
    }

    public DishTo getDish(int id) {
        return adminService.getDish(id);
    }

    public List<DishTo> getAllDishToday() {
        return adminService.getAllDishToday();
    }

    public void deleteDishToday(int id) {
        adminService.deleteDish(id);
    }
}
