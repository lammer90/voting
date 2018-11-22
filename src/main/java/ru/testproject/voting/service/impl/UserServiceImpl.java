package ru.testproject.voting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.repository.VoteRepository;
import ru.testproject.voting.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote addVote(Vote vote, int userId) {
        return voteRepository.save(vote, userId);
    }

    @Override
    public void updateVote(Vote vote, int userId) {
        voteRepository.save(vote, userId);
    }

    @Override
    public void deleteVote(int id, int userId) {
        voteRepository.delete(id, userId);
    }
}
