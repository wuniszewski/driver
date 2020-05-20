package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.wuniszewski.driver.converter.AdviceConverter;
import pl.wuniszewski.driver.converter.ExerciseConverter;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.dto.AnswerDto;
import pl.wuniszewski.driver.dto.ExerciseDto;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.entity.Exercise;
import pl.wuniszewski.driver.service.AdviceService;
import pl.wuniszewski.driver.service.ExerciseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/advices")
public class AdviceController {
    private AdviceService adviceService;
    private AdviceConverter adviceConverter;
    private ExerciseService exerciseService;
    private ExerciseConverter exerciseConverter;
    @Autowired
    public AdviceController(AdviceService adviceService, AdviceConverter adviceConverter, ExerciseService exerciseService, ExerciseConverter exerciseConverter) {
        this.adviceService = adviceService;
        this.adviceConverter = adviceConverter;
        this.exerciseService = exerciseService;
        this.exerciseConverter = exerciseConverter;
    }
    @GetMapping("/{id}")
    public AdviceDto getAdviceById(@PathVariable(name = "id") Long id) throws ResponseStatusException {
        Advice advice = adviceService.findById(id);
        AdviceDto dto = adviceConverter.convertToDto(advice);
        return dto;
    }
    @GetMapping
    public List<AdviceDto> getAllAdvices() {
        return adviceService.getAllAdvices().stream()
                .map(adviceConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdviceDto createAdvice(@RequestBody AdviceDto dto) {
        Advice advice = adviceConverter.convertToEntity(dto);
        Advice created = adviceService.create(advice);
        return adviceConverter.convertToDto(created);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdviceDto updateWholeAdvice(@PathVariable(name = "id") Long id, @RequestBody AdviceDto adviceDto) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No id given");
        }
        Advice toUpdate = adviceConverter.convertToEntity(adviceDto);
        toUpdate.setId(id);
        Advice updated = adviceService.update(toUpdate);
        return adviceConverter.convertToDto(updated);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable(name = "id") Long id) throws ResponseStatusException {
        adviceService.delete(id);
    }
    @GetMapping("/{id}/exercises")
    public List<ExerciseDto> getAllAnswersByAdvice (@PathVariable(name = "id") Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not given");
        }
        List<Exercise> exercises = exerciseService.getExercisesByAdviceId(id);
        return exercises.stream()
                .map(exerciseConverter::convertToDto)
                .collect(Collectors.toList());
    }
    @PostMapping("/{id}/exercises")
    public ExerciseDto addExerciseToAdvice (@PathVariable(name = "id") Long id, @RequestBody ExerciseDto exerciseDto) {
        Advice advice = adviceService.findById(id);
        Exercise newExercise = exerciseConverter.convertToEntity(exerciseDto);
        newExercise.setAdvice(advice);
        exerciseService.create(newExercise);
        return exerciseConverter.convertToDto(newExercise);
    }

}
