package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.wuniszewski.driver.service.OptionService;

@RestController
public class OptionController {
    private OptionService optionService;
    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }
}
