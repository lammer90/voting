package ru.testproject.voting.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.voting.model.Vote;
import ru.testproject.voting.repository.VoteRepository;
import ru.testproject.voting.repository.datajpa.JpaUserRepository;
import ru.testproject.voting.repository.datajpa.JpaVoteRepository;

@Repository
@Transactional(readOnly = true)
public class VoteRepositoryImpl implements VoteRepository {

    @Autowired
    private JpaVoteRepository jpaVoteRepository;

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    @Transactional
    public Vote save(Vote vote, int user_id) {
        if (!vote.isNew() && get(vote.getId(), user_id) == null) {
            return null;
        }
        vote.setUser(jpaUserRepository.getOne(user_id));
        return jpaVoteRepository.save(vote);
    }

    @Override
    @Transactional
    public boolean delete(int id, int user_id) {
        return jpaVoteRepository.delete(id, user_id) != 0;
    }

    private Vote get(int id, int userId) {
        return jpaVoteRepository.findByIdAndUser_Id(id, userId);
    }
}
