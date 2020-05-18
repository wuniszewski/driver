package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.service.AdviceService;

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
        Advice advice = adviceService.findById(id);
        AdviceDto dto = adviceService.convertToDto(advice);
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

}
