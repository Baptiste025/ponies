package be.ucll.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.model.Animal;
import be.ucll.model.DomainException;
import be.ucll.model.ServiceException;
import be.ucll.service.AnimalService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/animals")
public class animalRestController {

    private final AnimalService animalService;

    public animalRestController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{age}")
    public List<Animal> getAllAnimalsOlderThan(@PathVariable int age) {
        return animalService.getAllAnimalsOlderThan(age);
    }

    @GetMapping("/oldest")
    public Animal getOldestAnimal() {
        return animalService.getOldestAnimal();
    }
    

    @PostMapping
    public Animal registerAnimal(@Valid @RequestBody Animal newAnimal) {
        return animalService.registerAnimal(newAnimal);
    }
     
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ServiceException.class})
    public Map<String, String> handleServiceException(ServiceException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("ServiceException", ex.getMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DomainException.class})
    public Map<String, String> handleDomainException(DomainException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("DomainException", ex.getMessage());
        return errors;
    }
}
