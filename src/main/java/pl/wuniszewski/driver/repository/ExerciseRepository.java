package pl.wuniszewski.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wuniszewski.driver.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
