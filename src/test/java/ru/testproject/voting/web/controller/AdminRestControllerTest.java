package ru.testproject.voting.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.testproject.voting.TestUtil;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.Role;
import ru.testproject.voting.model.User;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.util.JsonUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.testproject.voting.TestUtil.*;
import static ru.testproject.voting.TestUtil.USER_4;
import static ru.testproject.voting.TestUtil.USER_5;

class AdminRestControllerTest extends AbstractRestControllerTest {

    @Autowired
    CommonService commonService;

    @Test
    void addRestaurant() throws Exception {
        Restaurant newRestaurant = new Restaurant("Test Restaurant");
        mockMvc.perform(post("/admin/restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newRestaurant)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> newRestaurant.setId(TestUtil.readFromJsonMvcResult(result, Restaurant.class).getId()));
        TestUtil.assertMatch(commonService.getAllRest(), List.of(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3, newRestaurant), "dishes", "votes");
    }

    @Test
    void deleteRestaurant() throws Exception {
        mockMvc.perform(delete("/admin/restaurant/" + RESTAURANT_3.getId()))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(commonService.getAllRest(), List.of(RESTAURANT_1, RESTAURANT_2), "dishes", "votes");
    }

    @Test
    void createUserWithLocation() throws Exception {
        User newUser = new User("User7", "password7", Role.ROLE_USER);
        mockMvc.perform(post("/admin/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newUser)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> newUser.setId(TestUtil.readFromJsonMvcResult(result, User.class).getId()));
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, USER_1, USER_2, USER_3, USER_4, USER_5, newUser), "votes");
    }

    @Test
    void updateUser() throws Exception {
        User newUser = new User(USER_1);
        newUser.setName("new Name");
        newUser.setPassword("new Pass");
        mockMvc.perform(put("/admin/users/" + newUser.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newUser)))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, newUser, USER_2, USER_3, USER_4, USER_5), "votes");
    }

    @Test
    void getUser() throws Exception {
        mockMvc.perform(get("/admin/users/" + USER_1.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readListFromJsonMvcResult(result, User.class), List.of(USER_1)));
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/admin/users/" + USER_1.getId()))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, USER_2, USER_3, USER_4, USER_5), "votes");
    }

    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(get("/admin/users"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readListFromJsonMvcResult(result, User.class), List.of(ADMIN, USER_1, USER_2, USER_3, USER_4, USER_5)));
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