package pl.wuniszewski.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wuniszewski.driver.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
