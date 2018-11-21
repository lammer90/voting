package ru.testproject.voting.repository.impl;

import ru.testproject.voting.model.User;
import ru.testproject.voting.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
