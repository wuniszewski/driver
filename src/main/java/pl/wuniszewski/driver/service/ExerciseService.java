package pl.wuniszewski.driver.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.dto.ExerciseDto;
import pl.wuniszewski.driver.entity.Exercise;
import pl.wuniszewski.driver.repository.ExerciseRepository;

@Service
public class ExerciseService {
    private ExerciseRepository repository;
    private ModelMapper modelMapper;
    @Autowired
    public ExerciseService(ExerciseRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
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
