package ru.testproject.voting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.service.UserService;
import ru.testproject.voting.web.SecurityUtil;


public abstract class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    public Vote addOrUpdateVote(int restId) {
        int userId = SecurityUtil.authUserId();
        return userService.addOrUpdateVoteToday(restId, userId);
    }

    public void deleteVoteToday() {
        int userId = SecurityUtil.authUserId();
        userService.deleteVoteToday(userId);
    }
}
