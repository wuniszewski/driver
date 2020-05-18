package pl.wuniszewski.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.repository.TagRepository;

@Service
public class TagService {
    private TagRepository repository;
    @Autowired
    public TagService(TagRepository repository) {
        this.repository = repository;
    }
}
