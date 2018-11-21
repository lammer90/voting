package ru.testproject.voting.model;

public class Restaurant extends AbstractNamedEntity{
    public Restaurant() {
    }

    public Restaurant(String name) {
        super(name);
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }
}
