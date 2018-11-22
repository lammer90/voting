package ru.testproject.voting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.service.UserService;
import ru.testproject.voting.web.SecurityUtil;

@Controller
public class UserController extends AbstractController{

    @Autowired
    private UserService userService;

    public Vote addVote(Vote vote){
        int userId = SecurityUtil.authUserId();
        return userService.addVote(vote, userId);
    }

    public void updateVote(Vote vote){
        int userId = SecurityUtil.authUserId();
        userService.updateVote(vote, userId);
    }

    public void deleteVote(int id){
        int userId = SecurityUtil.authUserId();
        userService.deleteVote(id, userId);
    }
}
