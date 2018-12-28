package ru.testproject.voting.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testproject.voting.TestUtil;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.service.AdminService;

import java.util.List;

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
    void addUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void addDish() {
    }

    @Test
    void updateDish() {
    }

    @Test
    void getDish() {
    }

    @Test
    void deleteDish() {
    }
}