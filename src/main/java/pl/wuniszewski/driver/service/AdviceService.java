package pl.wuniszewski.driver.service;

import lombok.extern.log4j.Log4j2;
import org.apache.el.stream.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.entity.Advice;
import pl.wuniszewski.driver.repository.AdviceRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Log4j2
public class AdviceService {
    private AdviceRepository repository;
    private ModelMapper modelMapper;
    @Autowired
    public AdviceService(AdviceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public Advice findById(Long id) throws ResponseStatusException {
        return repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find resource with given id"));
    }
    public List<Advice> getAllAdvices () {
        return repository.findAll();
    }
    public Advice create (Advice advice) {
        log.info("created" + advice.toString());
        return repository.save(advice);
    }
    public Advice update (Advice advice) {
        log.info("updated: " + advice.toString());
        return repository.save(advice);
    }
    public boolean delete (Long id) throws ResponseStatusException{
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Given not existing id");
        }
        return repository.findById(id).isEmpty();
    }
    public AdviceDto convertToDto (Advice entity) {
        return modelMapper.map(entity, AdviceDto.class);
    }
    public Advice convertToEntity (AdviceDto dto) {
        return modelMapper.map(dto, Advice.class);
    }
}
