package pl.wuniszewski.driver.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.wuniszewski.driver.dto.TagDto;
import pl.wuniszewski.driver.entity.Tag;
import pl.wuniszewski.driver.repository.TagRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TagService {
    private TagRepository repository;
    private ModelMapper modelMapper;
    @Autowired
    public TagService(TagRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public Tag findById(Long id) throws ResponseStatusException {
        return repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find resource with given id"));
    }
    public Tag create (Tag tag) {
        return repository.save(tag);
    }
    public Tag update (Tag tag) {
        return repository.save(tag);
    }
    public boolean delete (Long id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }
    public Tag getTagByName (String name) throws ResponseStatusException {
        return repository.getTagByName(name).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This tag doesn't exist"));
    }
    public List<Tag> getAllTags () {
        return repository.findAll();
    }
}
