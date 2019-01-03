package ru.testproject.voting.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.testproject.voting.TestUtil;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.util.JsonUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.testproject.voting.TestUtil.RESTAURANT_1;
import static ru.testproject.voting.TestUtil.RESTAURANT_2;
import static ru.testproject.voting.TestUtil.RESTAURANT_3;

class AdminRestControllerTest extends AbstractRestControllerTest{

    @Autowired
    CommonService commonService;

    @Test
    void addRestaurant() throws Exception {
        Restaurant restaurant = new Restaurant("Test Restaurant");
        mockMvc.perform(post("/admin/restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(restaurant)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> restaurant.setId(TestUtil.readFromJsonMvcResult(result, Restaurant.class).getId()));
        TestUtil.assertMatch(commonService.getAllRest(), List.of(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3, restaurant),  "dishes", "votes");
    }

    @Test
    void deleteRestaurant() throws Exception {
        mockMvc.perform(delete("/admin/restaurant/" + RESTAURANT_3.getId()))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(commonService.getAllRest(), List.of(RESTAURANT_1, RESTAURANT_2),  "dishes", "votes");
    }

    @Test
    void createUserWithLocation() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void addDishToday() {
    }

    @Test
    void updateDishToday() {
    }

    @Test
    void getDish() {
    }

    @Test
    void getAllDishToday() {
    }

    @Test
    void deleteDishToday() {
    }
}