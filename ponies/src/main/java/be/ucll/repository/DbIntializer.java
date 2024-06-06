package be.ucll.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import be.ucll.model.Animal;

@Component
public class DbIntializer {
    private final AnimalRepository animalRepository;

    public DbIntializer(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
        
        List<Animal> animals = Arrays.asList(
            new Animal("Mali", 3),
            new Animal("Mina", 11),
            new Animal("Bélé", 8),
            new Animal("Jules", 6)
        );
        animalRepository.saveAll(animals);
    }
}
