package ru.testproject.voting.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.testproject.voting.service.AdminService;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
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