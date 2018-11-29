package ru.testproject.voting.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.service.UserService;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
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
    }

    @Test
    public void getAllDishesFilterByRestToday(int rest_id){
    }
}