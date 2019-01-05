package ru.testproject.voting.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.testproject.voting.service.impl.auth.UserAuthService;

import static java.util.Objects.requireNonNull;

public class SecurityUtil {
    public static UserAuthService.AuthUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof UserAuthService.AuthUser) ? (UserAuthService.AuthUser) principal : null;
    }

    public static UserAuthService.AuthUser get() {
        UserAuthService.AuthUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    private SecurityUtil() {
    }

    public static int authUserId() {
        return get().getId();
    }
}
