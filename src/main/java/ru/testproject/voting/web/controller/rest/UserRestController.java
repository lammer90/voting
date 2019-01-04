package ru.testproject.voting.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.service.UserService;
import ru.testproject.voting.web.controller.UserController;

@RestController
@RequestMapping("/vote")
public class UserRestController extends UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/{id}")
    public void vote(@PathVariable("id") int restId) {
        super.addOrUpdateVote(restId);
    }

    @Override
    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVoteToday() {
        super.deleteVoteToday();
    }
}
