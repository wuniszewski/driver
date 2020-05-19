package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.wuniszewski.driver.converter.AdviceConverter;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.service.AdviceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/advices")
public class AdviceController {
    private AdviceService adviceService;
    private AdviceConverter adviceConverter;

    @Autowired
    public AdviceController(AdviceService adviceService, AdviceConverter adviceConverter) {
        this.adviceService = adviceService;
        this.adviceConverter = adviceConverter;
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

}
