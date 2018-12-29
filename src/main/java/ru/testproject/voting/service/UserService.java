package ru.testproject.voting.service;

import ru.testproject.voting.model.Vote;

import java.time.LocalDate;

public interface UserService {
    default Vote addOrUpdateVoteToday(int restId, int userId) {
        return addOrUpdateVote(restId, userId, LocalDate.now(), 11);
    }

    default void deleteVoteToday(int userId) {
        deleteVote(userId, LocalDate.now(), 11);
    }

    Vote addOrUpdateVote(int restId, int userId, LocalDate date, int time);

    void deleteVote(int userId, LocalDate date, int time);
}
