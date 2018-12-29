package ru.testproject.voting.util;

import ru.testproject.voting.model.AbstractBaseEntity;
import ru.testproject.voting.to.DishTo;
import ru.testproject.voting.util.exception.NotFoundException;

import java.time.LocalTime;

public class VerifyUtil {

    public static <T> T chekObject(T obj, String msg) {
        if (obj == null) {
            throw new NotFoundException(msg);
        }
        return obj;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException(msg);
        }
    }

    public static void checkEmptyString(String str, String msg) {
        if ("".equals(str)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static boolean chekTime() {
        return LocalTime.now().getHour() < 11;
    }
}
