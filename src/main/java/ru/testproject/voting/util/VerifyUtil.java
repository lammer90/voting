package ru.testproject.voting.util;

import ru.testproject.voting.util.exception.NotFoundException;

public class VerifyUtil {
    public static <T> T chekObject(T obj, String msg) {
        if (obj == null) {
            throw new NotFoundException(msg);
        }
        return obj;
    }
}
