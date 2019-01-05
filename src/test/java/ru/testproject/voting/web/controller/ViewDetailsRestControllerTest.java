package ru.testproject.voting.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import ru.testproject.voting.TestUtil;
import ru.testproject.voting.model.AbstractNamedEntity;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.User;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.to.RestaurantTo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.testproject.voting.TestUtil.*;
import static ru.testproject.voting.TestUtil.USER_5;

class ViewDetailsRestControllerTest extends AbstractRestControllerTest{

    @Test
    void getAllRest() throws Exception {
        mockMvc.perform(get("/viewDetails/restaurants")
                .with(userHttpBasic(USER_1)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readListFromJsonMvcResult(result, Restaurant.class), List.of(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3)));
    }

    @Test
    void getAllRestWithVotesAndDishesToday() throws Exception {
        mockMvc.perform(get("/viewDetails/resultOfVoting")
                .with(userHttpBasic(USER_1)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> readListFromJsonMvcResult(result, RestaurantTo.class)
                        .forEach((r) -> TestUtil.assertMatch(new ArrayList<>(r.getDishes()).stream().sorted(Comparator.comparing(DishTo::getName)).collect(Collectors.toList())
                        , commonService.getAllDishesFilterByRestToday(r.getId()))));
    }

    @Test
    void getAllDishesFilterByRestToday() throws Exception {
        mockMvc.perform(get("/viewDetails/dishesBy/" + RESTAURANT_1.getId())
                .with(userHttpBasic(USER_1)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readListFromJsonMvcResult(result, DishTo.class), List.of(DISH_1_BURGER, DISH_2_BURGER, DISH_3_BURGER), "id"));
    }
}