package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.service.AdviceService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/advices")
public class AdviceController {
    private AdviceService adviceService;
    @Autowired
    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }
    @GetMapping("/{id}")
    public AdviceDto getAdviceById (@PathVariable(name = "id") Long id) {
        AdviceDto dto;
        try {
            Advice advice = adviceService.findById(id);
            dto = adviceService.convertToDto(advice);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find resource with given id");
        }
        return dto;
    }
    @GetMapping
    public List<AdviceDto> getAllAdvices () {
        return adviceService.getAllAdvices().stream()
                .map(adviceService::convertToDto)
                .collect(Collectors.toList());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdviceDto createAdvice(@RequestBody AdviceDto dto) {
        Advice advice = adviceService.convertToEntity(dto);
        Advice created = adviceService.create(advice);
        return adviceService.convertToDto(created);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdviceDto updateWholeAdvice (@PathVariable(name = "id") Long id, @RequestBody AdviceDto adviceDto) {
        if (id == null) {
            return null;
        }
        Advice toUpdate = adviceService.convertToEntity(adviceDto);
        toUpdate.setId(id);
        Advice updated =adviceService.update(toUpdate);
        return adviceService.convertToDto(updated);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById (@PathVariable(name = "id") Long id) {
        try {
            adviceService.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Given not existing id");
        }
    }

}
