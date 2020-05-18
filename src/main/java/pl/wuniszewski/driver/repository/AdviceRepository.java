package pl.wuniszewski.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wuniszewski.driver.entity.Advice;

public interface AdviceRepository extends JpaRepository<Advice, Long> {
}
