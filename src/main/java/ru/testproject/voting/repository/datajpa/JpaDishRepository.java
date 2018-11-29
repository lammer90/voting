package ru.testproject.voting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproject.voting.model.Dish;

public interface JpaDishRepository extends JpaRepository<Dish, Integer> {
}
