package ru.testproject.voting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproject.voting.model.Vote;

public interface JpaVoteRepository extends JpaRepository<Vote, Integer> {
}
