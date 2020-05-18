package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.wuniszewski.driver.service.TagService;

@RestController
public class TagController {
    private TagService tagService;
    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }
}
