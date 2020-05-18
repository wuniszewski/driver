package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.service.AdviceService;

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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdviceDto createAdvice(AdviceDto dto) {
        Advice advice = adviceService.convertToEntity(dto);
        Advice created = adviceService.create(advice);
        return adviceService.convertToDto(created);
    }

}
