package ru.testproject.voting.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.testproject.voting.TestUtil;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.Role;
import ru.testproject.voting.model.User;
import ru.testproject.voting.service.AdminService;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.util.JsonUtil;
import ru.testproject.voting.util.exception.TimeLimitException;

import java.time.LocalDate;
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
    AdminService adminService;

    @Test
    void addRestaurant() throws Exception {
        Restaurant newRestaurant = new Restaurant("Test Restaurant");
        mockMvc.perform(post("/admin/restaurant")
                .with(userHttpBasic(ADMIN))
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
        mockMvc.perform(delete("/admin/restaurant/" + RESTAURANT_3.getId())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(commonService.getAllRest(), List.of(RESTAURANT_1, RESTAURANT_2), "dishes", "votes");
    }

    @Test
    void createUser() throws Exception {
        User newUser = new User("User7", "password7", Role.ROLE_USER);
        mockMvc.perform(post("/admin/users")
                .with(userHttpBasic(ADMIN))
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
                .with(userHttpBasic(ADMIN))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newUser)))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, newUser, USER_2, USER_3, USER_4, USER_5), "votes");
    }

    @Test
    void getUser() throws Exception {
        mockMvc.perform(get("/admin/users/" + USER_1.getId())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readListFromJsonMvcResult(result, User.class), List.of(USER_1)));
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/admin/users/" + USER_1.getId())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(adminService.getAllUsers(), List.of(ADMIN, USER_2, USER_3, USER_4, USER_5), "votes");
    }

    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(get("/admin/users")
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readListFromJsonMvcResult(result, User.class), List.of(ADMIN, USER_1, USER_2, USER_3, USER_4, USER_5)));
    }

    @Test
    void createDishToday() throws Exception {
        DishTo newDish = new DishTo("Новый бургер", 15000, RESTAURANT_1.getId());
        mockMvc.perform(post("/admin/dishes")
                .with(userHttpBasic(ADMIN))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDish)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> newDish.setId(TestUtil.readFromJsonMvcResult(result, Dish.class).getId()));
        TestUtil.assertMatch(commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()), List.of(DISH_1_BURGER, newDish, DISH_2_BURGER, DISH_3_BURGER), "id");
    }

    @Test
    void updateDishToday() throws Exception {
        int id = commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()).get(0).getId();
        DishTo newDish = new DishTo(adminService.getDish(id));
        newDish.setPrice(20000);
        newDish.setName("Обновленный бургер");
        mockMvc.perform(put("/admin/dishes/" + newDish.getId())
                .with(userHttpBasic(ADMIN))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDish)))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()), List.of(newDish, DISH_2_BURGER, DISH_3_BURGER), "id");
    }

    @Test
    void getDish() throws Exception {
        int id = commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()).get(0).getId();
        mockMvc.perform(get("/admin/dishes/" + id)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readListFromJsonMvcResult(result, Dish.class), List.of(new Dish(DISH_1_BURGER)), "id", "restaurant"));
    }

    @Test
    void getAllDishToday() throws Exception {
        mockMvc.perform(get("/admin/dishes")
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertEquals(9, readListFromJsonMvcResult(result, Dish.class).size()));
    }

    @Test
    void deleteDishToday() throws Exception {
        int id = commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()).get(0).getId();
        mockMvc.perform(delete("/admin/dishes/" + id)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent())
                .andDo(print());
        TestUtil.assertMatch(commonService.getAllDishesFilterByRestToday(RESTAURANT_1.getId()), List.of(DISH_2_BURGER, DISH_3_BURGER), "id");
    }
}