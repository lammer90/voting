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
import java.time.LocalTime;

import static ru.testproject.voting.util.VerifyUtil.chekObject;

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
        deleteVote(userId);
        if (voteRepository.getByDate(today, userId) == null) {
            return addVote(new Vote(today, restaurant), userId);
        } else {
            throw new TimeLimitException("Voting time is over");
        }
    }

    public Vote addVote(Vote vote, int userId) {
        return voteRepository.save(vote, userId);
    }

    @Override
    public boolean deleteVote(int userId) {
        if (LocalTime.now().getHour() < 11) {
            voteRepository.delete(LocalDate.now(), userId);
            return true;
        }
        return false;
    }
}
