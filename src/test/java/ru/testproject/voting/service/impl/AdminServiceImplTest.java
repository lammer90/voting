package ru.testproject.voting.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testproject.voting.TestUtil;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.Role;
import ru.testproject.voting.model.User;
import ru.testproject.voting.service.AdminService;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.util.exception.NotFoundException;
import ru.testproject.voting.util.exception.TimeLimitException;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.testproject.voting.TestUtil.*;


class AdminServiceImplTest extends CommonServiceImplTest {

    @Autowired
    private AdminService adminService;

    @Test
    void addRestaurant() {
        Restaurant restaurant = adminService.addRestaurant("Test Restaurant");
        TestUtil.assertMatch(commonService.getAllRest(), List.of(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3, restaurant), "dishes", "votes");
    }

    @Test
    void deleteRestaurant() {
        adminService.deleteRestaurant(SUSHI_MARKET_SEQ);
        TestUtil.assertMatch(commonService.getAllRest(), List.of(RESTAURANT_1, RESTAURANT_2), "dishes", "votes");
    }

    @Test
    void deleteRestaurantNotFound() {
        assertThrows(NotFoundException.class, () ->
                adminService.deleteRestaurant(123456));
    }

    @Test
    void addUser() {
        User newUser = adminService.addUser(new User("User7", "password7", Role.ROLE_USER));
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, USER_1, USER_2, USER_3, USER_4, USER_5, newUser), "votes");
    }

    @Test
    void updateUser() {
        User newUser = new User(USER_1);
        newUser.setName("new Name");
        newUser.setPassword("new Pass");
        adminService.updateUser(newUser);
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, newUser, USER_2, USER_3, USER_4, USER_5), "votes");
    }

    @Test
    void getUser() {
        TestUtil.assertMatch(adminService.getUser(ADMIN.getId()), ADMIN, "votes");
    }

    @Test
    void deleteUser() {
        adminService.deleteUser(USER_1.getId());
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, USER_2, USER_3, USER_4, USER_5), "votes");
    }

    @Test
    void getAllUsers() {
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, USER_1, USER_2, USER_3, USER_4, USER_5), "votes");
    }

    @Test
    void addDish() {
        DishTo newDish = new DishTo("Новый бургер", 150.00, RESTAURANT_1);
        adminService.addDish(newDish);
        TestUtil.assertMatch(commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()), List.of(DISH_1_BURGER, new Dish(newDish), DISH_2_BURGER, DISH_3_BURGER), "id", "restaurant");
    }

    @Test
    void updateDishTimeException() {
        DishTo newDish = new DishTo(adminService.getDish(100009));

        assertThrows(TimeLimitException.class, () ->
                adminService.updateDish(newDish));
    }

    @Test
    void updateDish() {
        int id = commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()).get(0).getId();
        DishTo newDish = new DishTo(adminService.getDish(id));
        newDish.setPrice(200.00);
        newDish.setName("Обновленный бургер");
        adminService.updateDish(newDish);

        TestUtil.assertMatch(commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()), List.of(new Dish(newDish), DISH_2_BURGER, DISH_3_BURGER), "id", "restaurant");
    }

    @Test
    void getAllDishByDate() {
        assertEquals(9, adminService.getAllDishByDate(LocalDate.now()).size());
    }

    @Test
    void deleteDish() {
        int id = commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()).get(0).getId();
        adminService.deleteDish(id);
        TestUtil.assertMatch(commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()), List.of(DISH_2_BURGER, DISH_3_BURGER), "id", "restaurant");
    }

    @Test
    void getDish() {
        int id = commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()).get(0).getId();
        TestUtil.assertMatch(adminService.getDish(id), DISH_1_BURGER, "id", "restaurant");
    }
}