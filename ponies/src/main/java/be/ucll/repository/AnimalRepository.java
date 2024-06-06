package be.ucll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ucll.model.Animal;
import java.util.List;



@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByName(String name);

    List<Animal> findAllByAgeGreaterThanEqual(int age);

    Animal findTopByOrderByAgeDesc();
}
