package ru.testproject.voting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.User;
import ru.testproject.voting.service.AdminService;

import java.util.List;

@Controller
public class AdminController extends AbstractController{

    @Autowired
    private AdminService adminService;

    public Restaurant addRestaurant(Restaurant restaurant){
        return adminService.addRestaurant(restaurant);
    }

    public void deleteRestaurant(int id){
        adminService.deleteRestaurant(id);
    }

    public User addUser(User user){
        return adminService.addUser(user);
    }

    public void updateUser(User user){
        adminService.updateUser(user);
    }

    public void deleteUser(int id){
        adminService.deleteUser(id);
    }

    public List<User> getAllUsers(){
        return adminService.getAllUsers();
    }

    public Dish addDish(Dish dish){
        return adminService.addDish(dish);
    }

    public Dish getDish(int id){
        return adminService.getDish(id);
    }

    public void deleteDish(int id){
        adminService.deleteDish(id);
    }
}
