package ru.testproject.voting.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.voting.model.Dish;
import ru.testproject.voting.repository.DishRepository;
import ru.testproject.voting.repository.datajpa.JpaDishRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DishRepositoryImpl implements DishRepository {

    @Autowired
    private JpaDishRepository jpaDishRepository;

    @Override
    @Transactional
    public Dish save(Dish dish) {
        return jpaDishRepository.save(dish);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return jpaDishRepository.delete(id) != 0;
    }

    @Override
    public Dish get(int id) {
        return jpaDishRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dish> getAll() {
        return jpaDishRepository.findAll();
    }

    @Override
    public List<Dish> getAllFilterRestAndDate(int rest_id, LocalDate date) {
        return jpaDishRepository.findAllByDateAndRestaurant_Id(date, rest_id);
    }
}
