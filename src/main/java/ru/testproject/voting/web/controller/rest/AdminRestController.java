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
    public ResponseEntity<User> createUser(@RequestBody User user) {
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
    public User getUser(@PathVariable("id") int id) {
        return super.getUser(id);
    }

    @Override
    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int id) {
        super.deleteUser(id);
    }

    @Override
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return super.getAllUsers();
    }

    @PostMapping(value = "/dishes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createDishToday(@RequestBody DishTo dishTo) {
        Dish dish = super.addDishToday(dishTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/dishes" + "/{id}")
                .buildAndExpand(dish.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(dish);
    }

    @Override
    @PutMapping(value = "/dishes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateDishToday(@RequestBody DishTo dishTo, @PathVariable("id") int id) {
        super.updateDishToday(dishTo, id);
    }

    @Override
    @GetMapping(value = "/dishes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish getDish(@PathVariable("id") int id) {
        return super.getDish(id);
    }

    @Override
    @GetMapping(value = "/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAllDishToday() {
        return super.getAllDishToday();
    }

    @Override
    @DeleteMapping(value = "/dishes/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDishToday(@PathVariable("id") int id) {
        super.deleteDishToday(id);
    }
}
