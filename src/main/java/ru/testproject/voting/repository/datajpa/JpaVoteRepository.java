package ru.testproject.voting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.testproject.voting.model.Vote;

import java.time.LocalDate;

public interface JpaVoteRepository extends JpaRepository<Vote, Integer> {
    Vote findByIdAndUser_Id(int id, int user_id);

    Vote findByDateAndUser_Id(LocalDate date, int user_id);

    @Modifying
    @Query("DELETE FROM Vote v WHERE v.date=:date AND v.user.id=:user_id")
    int delete(@Param("date") LocalDate date, @Param("user_id") int userId);
}
