package ru.testproject.voting.repository;

import ru.testproject.voting.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    Vote save(Vote vote, int user_id);

    boolean delete(int id, int user_id);
}
