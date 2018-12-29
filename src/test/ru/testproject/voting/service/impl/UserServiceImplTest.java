package ru.testproject.voting.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testproject.voting.TestUtil;
import ru.testproject.voting.model.AbstractNamedEntity;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.service.UserService;
import ru.testproject.voting.util.exception.TimeLimitException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.testproject.voting.TestUtil.RESTAURANT_1;
import static ru.testproject.voting.TestUtil.RESTAURANT_3;

class UserServiceImplTest extends CommonServiceImplTest {

    Testing test = (restId, count) -> {
        commonService.getAllRestWithVotesAndDishesToday()
                .forEach(r -> {
                    if (r.getId().equals(restId)) {
                        assertEquals(r.getCountOfVotes(), count);
                    }
                });
    };

    @Autowired
    UserService userService;

    @Test
    void getAllRestWithVotesAndDishesToday() {
        commonService.getAllRestWithVotesAndDishesToday()
                .forEach((r) -> TestUtil.assertMatch(new ArrayList<Dish>(r.getDishes()).stream().sorted(Comparator.comparing(AbstractNamedEntity::getName)).collect(Collectors.toList())
                        , commonService.getAllDishesFilterByRestToday(r.getId())
                        , "id", "restaurant"));
    }

    @Test
    void newVoteBeforeTime() {
        userService.addOrUpdateVote(RESTAURANT_1.getId(), 100003, LocalDate.now(), LocalTime.now().getHour() + 1);
        test.runTest(RESTAURANT_1.getId(), 3);
    }

    @Test
    void newVoteUnderTime() {
        userService.addOrUpdateVote(RESTAURANT_1.getId(), 100003, LocalDate.now(), LocalTime.now().getHour() - 1);
        test.runTest(RESTAURANT_1.getId(), 3);
    }

    @Test
    void repeatVoteBeforeTime() {
        userService.addOrUpdateVote(RESTAURANT_1.getId(), 100000, LocalDate.now(), LocalTime.now().getHour() + 1);
        test.runTest(RESTAURANT_1.getId(), 3);
    }

    @Test
    void repeatVoteUnderTime() {
        assertThrows(TimeLimitException.class, () ->
                userService.addOrUpdateVote(RESTAURANT_1.getId(), 100000, LocalDate.now(), LocalTime.now().getHour() - 1));
    }

    @Test
    void deleteVoteBeforeTime() {
        userService.deleteVote(100000, LocalDate.now(), LocalTime.now().getHour() + 1);
        test.runTest(RESTAURANT_3.getId(), 0);

    }

    @Test
    void deleteVoteUnderTime() {
        assertThrows(TimeLimitException.class, () ->
                userService.deleteVote(100000, LocalDate.now(), LocalTime.now().getHour() - 1));
    }

    private interface Testing {
        void runTest(int restId, int count);
    }
}