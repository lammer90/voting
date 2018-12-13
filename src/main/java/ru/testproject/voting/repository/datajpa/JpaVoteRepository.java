package ru.testproject.voting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.testproject.voting.model.Vote;

public interface JpaVoteRepository extends JpaRepository<Vote, Integer> {
    Vote findByIdAndUser_Id(int id, int user_id);

    @Query("DELETE FROM Vote v WHERE v.id=:id AND v.user.id=:user_id")
    int delete(@Param("id") int id, @Param("user_id") int userId);
}
