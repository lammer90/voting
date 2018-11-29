package ru.testproject.voting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproject.voting.model.Restaurant;

public interface JpaRestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
