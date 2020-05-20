package pl.wuniszewski.driver.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.wuniszewski.driver.dto.ExerciseDto;
import pl.wuniszewski.driver.entity.Exercise;
import pl.wuniszewski.driver.repository.ExerciseRepository;

import java.util.List;

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
    public List<Exercise> getExercisesByAdviceId (Long adviceId) throws ResponseStatusException {
        return repository.findAllByAdvice_Id(adviceId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong advice id, or no exercises found"));
    }
}
