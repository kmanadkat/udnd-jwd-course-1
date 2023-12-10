package com.udacity.jdnd.webapp1.exercise;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalFormService {
    private List<AnimalForm> animals;

    @PostConstruct
    public void postConstruct() {
        this.animals = new ArrayList<>();
    }

    public void addNewAnimal(AnimalForm animalForm) {
        this.animals.add(animalForm);
    }

    public List<AnimalForm> getAnimals() {
        return new ArrayList<>(this.animals);
    }
}
