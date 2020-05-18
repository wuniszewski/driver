package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.wuniszewski.driver.service.AnswerService;

@RestController
public class AnswerController {
    private AnswerService optionService;
    @Autowired
    public AnswerController(AnswerService optionService) {
        this.optionService = optionService;
    }
}
