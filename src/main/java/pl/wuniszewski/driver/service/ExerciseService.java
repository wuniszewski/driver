package pl.wuniszewski.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.entity.Exercise;
import pl.wuniszewski.driver.repository.ExerciseRepository;

@Service
public class ExerciseService {
    private ExerciseRepository repository;

    @Autowired
    public ExerciseService(ExerciseRepository repository) {
        this.repository = repository;
    }
    public Exercise findById(Long id) {
        return repository.getOne(id);
    }
    public Exercise create (Exercise exercise) {
        return repository.save(exercise);
    }
    public Exercise update (Exercise exercise) {
        return repository.save(exercise);
    }
    public boolean delete (Long id) {
        repository.deleteById(id);
        return repository.getOne(id) == null ? true : false;
    }
}
