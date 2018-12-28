package ru.testproject.voting;

import ru.testproject.voting.model.Restaurant;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtil {

    public static final int SUSHI_MARKET_SEQ = 100006;

    public static final Restaurant RESTAURANT_1 = new Restaurant(100007, "PAPA BURGER");
    public static final Restaurant RESTAURANT_2 = new Restaurant(100008, "PASTA BAR");
    public static final Restaurant RESTAURANT_3 = new Restaurant(100006, "SUSHI MARKET");
    //public static final Restaurant RESTAURANT_4 = new Restaurant(100009, "Test Restaurant");

    public static <T> void assertMatch(T actual, T expected, String...ignoreProps) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, ignoreProps);
    }

    public static <T> void assertMatch(Iterable<T> actual, Iterable<T> expected, String...ignoreProps) {
        assertThat(actual).usingElementComparatorIgnoringFields(ignoreProps).isEqualTo(expected);
    }
}
