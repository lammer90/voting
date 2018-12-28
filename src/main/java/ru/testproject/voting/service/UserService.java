package ru.testproject.voting.service;

import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.to.RestaurantTo;

import java.util.List;

public interface UserService {
    Vote addOrUpdateVote(int restId, int userId);

    void deleteVote(int userId);
}
