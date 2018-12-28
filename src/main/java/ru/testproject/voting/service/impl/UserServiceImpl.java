package ru.testproject.voting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.repository.RestaurantRepository;
import ru.testproject.voting.repository.VoteRepository;
import ru.testproject.voting.service.UserService;
import ru.testproject.voting.util.exception.TimeLimitException;

import java.time.LocalDate;

import static ru.testproject.voting.util.VerifyUtil.checkNotFound;
import static ru.testproject.voting.util.VerifyUtil.chekObject;
import static ru.testproject.voting.util.VerifyUtil.chekTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Vote addOrUpdateVote(int restId, int userId) {
        Restaurant restaurant = chekObject(restaurantRepository.get(restId), "No restaurant found");
        LocalDate today = LocalDate.now();
        if (chekTime()) {
            voteRepository.delete(LocalDate.now(), userId);
        }
        if (voteRepository.getByDate(today, userId) == null) {
            return addVote(new Vote(today, restaurant), userId);
        } else {
            throw new TimeLimitException("Voting time is over");
        }
    }

    @Override
    public void deleteVote(int userId) {
        if (!chekTime()) {
            throw new TimeLimitException("Voting time is over");
        }
        checkNotFound(voteRepository.delete(LocalDate.now(), userId), "No vote found");
    }

    private Vote addVote(Vote vote, int userId) {
        return voteRepository.save(vote, userId);
    }
}
