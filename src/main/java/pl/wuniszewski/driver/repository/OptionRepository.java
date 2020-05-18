package pl.wuniszewski.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wuniszewski.driver.entity.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
