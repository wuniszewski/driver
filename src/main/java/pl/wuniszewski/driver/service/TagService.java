package pl.wuniszewski.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.entity.Tag;
import pl.wuniszewski.driver.repository.TagRepository;

@Service
public class TagService {
    private TagRepository repository;
    @Autowired
    public TagService(TagRepository repository) {
        this.repository = repository;
    }
    public Tag findById(Long id) {
        return repository.getOne(id);
    }
    public Tag create (Tag tag) {
        return repository.save(tag);
    }
    public Tag update (Tag tag) {
        return repository.save(tag);
    }
    public boolean delete (Long id) {
        repository.deleteById(id);
        return repository.getOne(id) == null ? true : false;
    }
}
