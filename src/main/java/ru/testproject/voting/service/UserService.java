package ru.testproject.voting.service;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.to.RestaurantTo;

import java.util.List;

public interface UserService{
    Vote addVote(Vote vote, int userId);

    void updateVote(Vote vote, int userId);

    void deleteVote(int id, int userId);
}
