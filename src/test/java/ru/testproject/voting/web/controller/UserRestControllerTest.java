package ru.testproject.voting.web.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testproject.voting.service.UserService;
import ru.testproject.voting.util.VerifyUtil;
import ru.testproject.voting.util.exception.TimeLimitException;
import ru.testproject.voting.web.SecurityUtil;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.testproject.voting.TestUtil.*;
import static ru.testproject.voting.TestUtil.ADMIN;

class UserRestControllerTest extends AbstractRestControllerTest {

    @Autowired
    UserService userService;

    @Test
    void newVoteBeforeTime() throws Exception {
        //SecurityUtil.setAuthUserId(100003);
        mockMvc.perform(post("/vote/" + RESTAURANT_1.getId())
                .with(userHttpBasic(USER_4)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
        test.runTest(commonService, RESTAURANT_1.getId(), 3);
    }

    @Test
    void repeatVoteBeforeUnderTime() throws Exception {
        //SecurityUtil.setAuthUserId(100000);
        if (VerifyUtil.chekTime(11)) {
            mockMvc.perform(post("/vote/" + RESTAURANT_1.getId())
                    .with(userHttpBasic(USER_1)))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
            test.runTest(commonService, RESTAURANT_1.getId(), 3);
        } else {
            mockMvc.perform(post("/vote/" + RESTAURANT_1.getId())
                    .with(userHttpBasic(USER_1)))
                    .andExpect(status().isInternalServerError());
            //assertThrowsWithCause(() -> mockMvc.perform(post("/vote/" + RESTAURANT_1.getId()).with(userHttpBasic(USER_1))), TimeLimitException.class);
        }
    }

    @Test
    void deleteVoteBeforeUnderToday() throws Exception {
        //SecurityUtil.setAuthUserId(100000);
        if (VerifyUtil.chekTime(11)) {
            mockMvc.perform(delete("/vote")
                    .with(userHttpBasic(USER_1)))
                    .andExpect(status().isNoContent())
                    .andDo(print());
            test.runTest(commonService, RESTAURANT_3.getId(), 0);
        } else {
            mockMvc.perform(delete("/vote")
                    .with(userHttpBasic(USER_1)))
                    .andExpect(status().isInternalServerError());
            //assertThrowsWithCause(() -> mockMvc.perform(delete("/vote").with(userHttpBasic(USER_1))), TimeLimitException.class);
        }
    }

    private <T extends Exception> void assertThrowsWithCause(Callable callable, Class<T> aClass) {
        assertThrows(aClass, () -> {
            try {
                callable.call();
            } catch (Exception e) {
                throw e.getCause();
            }
        });
    }
}
