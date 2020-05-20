package pl.wuniszewski.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wuniszewski.driver.entity.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    public Optional<List<Exercise>> findAllByAdvice_Id (Long id);
}
