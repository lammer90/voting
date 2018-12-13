package ru.testproject.voting.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.testproject.voting.service.AdminService;

@SpringJUnitConfig(locations ={
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-db.xml"
})
public class AdminControllerTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void addRestaurant() {
    }

    @Test
    public void deleteRestaurant() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void getAllUsers() {
    }

    @Test
    public void addDish() {
    }

    @Test
    public void getDish() {
    }

    @Test
    public void deleteDish() {
    }
}