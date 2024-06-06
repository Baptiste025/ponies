package be.ucll.service;

import be.ucll.model.Animal;
import be.ucll.model.ServiceException;
import be.ucll.repository.AnimalRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public List<Animal> getAllAnimalsOlderThan(int minAge) {
        return animalRepository.findAllByAgeGreaterThanEqual(minAge);
    }

    public Animal getOldestAnimal() {
        return animalRepository.findTopByOrderByAgeDesc();
    }

    public Animal registerAnimal(Animal newAnimal) {
        List<Animal> animals = animalRepository.findAll();
        for (Animal animal : animals) {
            if (animal.getName().equals(newAnimal.getName())){
                throw new ServiceException("This name is already in the database");
            }
        }
        return animalRepository.save(newAnimal);
    }
}
