package ru.testproject.voting.web.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.User;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.web.controller.AdminController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController extends AdminController {

    @PostMapping(value = "/restaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return super.addRestaurant(restaurant.getName());
    }

    @Override
    @DeleteMapping(value = "/restaurant/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable("id") int id) {
        super.deleteRestaurant(id);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUserWithLocation(@RequestBody User user) {
        User created = super.addUser(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/users" + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User user, @PathVariable("id") int id) {
        super.updateUser(user, id);
    }

    @Override
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable("id")int id){
        return super.getUser(id);
    }

    @Override
    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id")int id) {
        super.deleteUser(id);
    }

    @Override
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return super.getAllUsers();
    }

    @Override
    public Dish addDishToday(DishTo dishTo) {
        return super.addDishToday(dishTo);
    }

    @Override
    public void updateDishToday(DishTo dishTo) {
        super.updateDishToday(dishTo);
    }

    @Override
    public Dish getDish(int id) {
        return super.getDish(id);
    }

    @Override
    public List<Dish> getAllDishToday() {
        return super.getAllDishToday();
    }

    @Override
    public void deleteDishToday(int id) {
        super.deleteDishToday(id);
    }
}
