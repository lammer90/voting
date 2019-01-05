package ru.testproject.voting.service.impl.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.testproject.voting.model.User;
import ru.testproject.voting.repository.UserRepository;

public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User " + s + " is not found");
        }
        return new AuthUser(user);
    }

    public class AuthUser extends org.springframework.security.core.userdetails.User{
        private static final long serialVersionUID = 1L;

        private int userId;

        public AuthUser(User user) {
            super(user.getName(), user.getPassword(), true, true, true, true, user.getRoles());
            this.userId = user.getId();
        }

        public int getId() {
            return userId;
        }
    }
}
