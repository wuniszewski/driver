package pl.wuniszewski.driver.service;

import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.entity.Answer;
import pl.wuniszewski.driver.entity.User;
import pl.wuniszewski.driver.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findById(Long id) {
        return userRepository.getOne(id);
    }
    public User create (User user) {
        return userRepository.save(user);
    }
    public User update (User user) {
        return userRepository.save(user);
    }
    public boolean delete (Long id) {
        userRepository.deleteById(id);
        return userRepository.getOne(id) == null ? true : false;
    }
}
