package ru.testproject.voting.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.voting.model.User;
import ru.testproject.voting.repository.UserRepository;
import ru.testproject.voting.repository.datajpa.JpaUserRepository;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {
    private static final Sort SORT = new Sort(Sort.Direction.ASC, "name");

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    @Transactional
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return jpaUserRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return jpaUserRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return jpaUserRepository.findAll(SORT);
    }
}
