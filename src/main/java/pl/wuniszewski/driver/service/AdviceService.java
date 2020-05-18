package pl.wuniszewski.driver.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.repository.AdviceRepository;

@Service
public class AdviceService {
    private AdviceRepository repository;
    private ModelMapper modelMapper;
    @Autowired
    public AdviceService(AdviceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public Advice findById(Long id) {
        return repository.getOne(id);
    }
    public Advice create (Advice advice) {
        return repository.save(advice);
    }
    public Advice update (Advice advice) {
        return repository.save(advice);
    }
    public boolean delete (Long id) {
        repository.deleteById(id);
        return repository.getOne(id) == null ? true : false;
    }
    public AdviceDto convertToDto (Advice entity) {
        return modelMapper.map(entity, AdviceDto.class);
    }
    public Advice convertToEntity (AdviceDto dto) {
        return modelMapper.map(dto, Advice.class);
    }
}
