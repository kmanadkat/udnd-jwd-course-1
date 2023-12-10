package com.udacity.jdnd.webapp1.exercise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {
    private AnimalFormService animalFormService;

    public ExerciseController(AnimalFormService service) {
        this.animalFormService = service;
    }

    @GetMapping
    public String getExercisePage(@ModelAttribute("animalMessage") AnimalForm animalForm, Model model){
        model.addAttribute("animals", animalFormService.getAnimals());
        return "exercise";
    }

    @PostMapping
    public String addNewAnimal(@ModelAttribute("animalMessage") AnimalForm animalForm, Model model) {
        animalFormService.addNewAnimal(animalForm);
        model.addAttribute("animals", animalFormService.getAnimals());
        return "exercise";
    }
}
