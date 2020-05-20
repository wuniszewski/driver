package pl.wuniszewski.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wuniszewski.driver.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin (String login);
}
