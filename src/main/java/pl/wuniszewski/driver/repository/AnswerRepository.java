package pl.wuniszewski.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wuniszewski.driver.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
