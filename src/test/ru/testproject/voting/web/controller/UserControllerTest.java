package ru.testproject.voting.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.service.UserService;
import ru.testproject.voting.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private CommonService commonService;

    @Test
    public void addVote() {
    }

    @Test
    public void updateVote() {
    }

    @Test
    public void deleteVote() {
    }

    @Test
    public void getAllRest(){
    }

    @Test
    public void getAllRestWithVotesAndDishesToday(){
        List<RestaurantTo> list = commonService.getAllRestWithVotesAndDishesByDate(LocalDate.of(2018, 11, 29));
    }

    @Test
    public void getAllDishesFilterByRestToday(){
    }
}