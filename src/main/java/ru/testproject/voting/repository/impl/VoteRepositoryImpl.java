package ru.testproject.voting.repository.impl;

import org.springframework.stereotype.Repository;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {
    @Override
    public Vote save(Vote vote, int user_id) {
        return null;
    }

    @Override
    public boolean delete(int id, int user_id) {
        return false;
    }

    @Override
    public Vote get(int id, int user_id) {
        return null;
    }

    @Override
    public List<Vote> getAllFilterRestAndDate(int rest_id, LocalDate date) {
        return null;
    }
}
