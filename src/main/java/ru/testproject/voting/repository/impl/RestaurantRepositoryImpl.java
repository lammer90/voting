package ru.testproject.voting.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.voting.model.Restaurant;
import ru.testproject.voting.repository.RestaurantRepository;
import ru.testproject.voting.repository.datajpa.JpaRestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    private JpaRestaurantRepository jpaRestaurantRepository;

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return jpaRestaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return jpaRestaurantRepository.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        return jpaRestaurantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAll() {
        return jpaRestaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getAllWithVotesAndDishesByDate(LocalDate date) {
        return jpaRestaurantRepository.getAllWithVotesAndDishesByDate(date);
    }
}
