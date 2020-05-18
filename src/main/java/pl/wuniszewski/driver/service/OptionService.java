package pl.wuniszewski.driver.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.dto.OptionDto;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.entity.Option;
import pl.wuniszewski.driver.repository.OptionRepository;

@Service
public class OptionService {
    private OptionRepository repository;
    private ModelMapper modelMapper;
    @Autowired
    public OptionService(OptionRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public Option findById(Long id) {
        return repository.getOne(id);
    }
    public Option create (Option option) {
        return repository.save(option);
    }
    public Option update (Option option) {
        return repository.save(option);
    }
    public boolean delete (Long id) {
        repository.deleteById(id);
        return repository.getOne(id) == null ? true : false;
    }
    public OptionDto convertToDto (Option entity) {
        return modelMapper.map(entity, OptionDto.class);
    }
    public Option convertToEntity (OptionDto dto) {
        return modelMapper.map(dto, Option.class);
    }
}
