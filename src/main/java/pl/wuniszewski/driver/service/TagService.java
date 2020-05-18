package pl.wuniszewski.driver.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.dto.TagDto;
import pl.wuniszewski.driver.entity.Tag;
import pl.wuniszewski.driver.repository.TagRepository;

@Service
public class TagService {
    private TagRepository repository;
    private ModelMapper modelMapper;
    @Autowired
    public TagService(TagRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
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
    public TagDto convertToDto (Tag entity) {
        return modelMapper.map(entity, TagDto.class);
    }
    public Tag convertToEntity (TagDto dto) {
        return modelMapper.map(dto, Tag.class);
    }
}
