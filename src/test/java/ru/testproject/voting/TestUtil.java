package ru.testproject.voting;

import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.model.Role;
import ru.testproject.voting.model.User;
import ru.testproject.voting.service.CommonService;
import ru.testproject.voting.service.impl.UserServiceImplTest;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.to.RestaurantTo;
import ru.testproject.voting.util.JsonUtil;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtil {

    public static final User USER_1 = new User(100000, "User1", "password1", Role.ROLE_USER);
    public static final User USER_2 = new User(100001, "User2", "password2", Role.ROLE_USER);
    public static final User USER_3 = new User(100002, "User3", "password3", Role.ROLE_USER);
    public static final User USER_4 = new User(100003, "User4", "password4", Role.ROLE_USER);
    public static final User USER_5 = new User(100004, "User5", "password5", Role.ROLE_USER);
    public static final User ADMIN  = new User(100005, "Admin", "admin", Role.ROLE_ADMIN);

    public static final int SUSHI_MARKET_SEQ = 100006;

    public static final Restaurant RESTAURANT_1 = new Restaurant(100007, "PAPA BURGER");
    public static final Restaurant RESTAURANT_2 = new Restaurant(100008, "PASTA BAR");
    public static final Restaurant RESTAURANT_3 = new Restaurant(100006, "SUSHI MARKET");

    public static final DishTo DISH_1_SUSHI = new DishTo(new Dish("ролл с угрем", 10000, RESTAURANT_3, LocalDate.now()));
    public static final DishTo DISH_2_SUSHI = new DishTo(new Dish("суши с лососем", 12000, RESTAURANT_3, LocalDate.now()));
    public static final DishTo DISH_3_SUSHI = new DishTo(new Dish("острый суп", 5000, RESTAURANT_3, LocalDate.now()));

    public static final DishTo DISH_1_BURGER = new DishTo(new Dish("бургер с говядиной", 14000, RESTAURANT_1, LocalDate.now()));
    public static final DishTo DISH_2_BURGER = new DishTo(new Dish("салат из овощей", 3000, RESTAURANT_1, LocalDate.now()));
    public static final DishTo DISH_3_BURGER = new DishTo(new Dish("суп грибной", 10000, RESTAURANT_1, LocalDate.now()));

    public static final DishTo DISH_1_PASTA = new DishTo(new Dish("паста с беконом", 12000, RESTAURANT_2, LocalDate.now()));
    public static final DishTo DISH_2_PASTA = new DishTo(new Dish("салат цезарь", 12000, RESTAURANT_2, LocalDate.now()));
    public static final DishTo DISH_3_PASTA = new DishTo(new Dish("булочка белая", 2000, RESTAURANT_2, LocalDate.now()));

    public static final List<RestaurantTo> RESTAURANTS_TO = new ArrayList<>();

    public static Testing test = (service, restId, count) -> {
        service.getAllRestWithVotesAndDishesToday()
                .forEach(r -> {
                    if (r.getId().equals(restId)) {
                        assertEquals(r.getCountOfVotes(), count);
                    }
                });
    };

    public interface Testing {
        void runTest(CommonService commonService, int restId, int count);
    }

    static {
    }

    public static <T> void assertMatch(T actual, T expected, String...ignoreProps) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, ignoreProps);
    }

    public static <T> void assertMatch(Iterable<T> actual, Iterable<T> expected, String...ignoreProps) {
        assertThat(actual).usingElementComparatorIgnoringFields(ignoreProps).isEqualTo(expected);
    }

    public static <T> T readFromJsonMvcResult(MvcResult result, Class<T> clazz) throws UnsupportedEncodingException {
        return JsonUtil.readValue(result.getResponse().getContentAsString(), clazz);
    }

    public static <T> List<T> readListFromJsonMvcResult(MvcResult result, Class<T> clazz) throws UnsupportedEncodingException {
        return JsonUtil.readValues(result.getResponse().getContentAsString(), clazz);
    }

    public static RequestPostProcessor userHttpBasic(User user) {
        return SecurityMockMvcRequestPostProcessors.httpBasic(user.getName(), user.getPassword());
    }
}
