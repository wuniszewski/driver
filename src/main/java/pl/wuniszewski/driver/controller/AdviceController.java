package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
