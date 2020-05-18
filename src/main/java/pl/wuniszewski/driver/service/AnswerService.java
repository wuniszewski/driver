package pl.wuniszewski.driver.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wuniszewski.driver.dto.AnswerDto;
import pl.wuniszewski.driver.entity.Answer;
import pl.wuniszewski.driver.repository.AnswerRepository;

@Service
public class AnswerService {
    private AnswerRepository repository;
    private ModelMapper modelMapper;
    @Autowired
    public AnswerService(AnswerRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public Answer findById(Long id) {
        return repository.getOne(id);
    }
    public Answer create (Answer answer) {
        return repository.save(answer);
    }
    public Answer update (Answer answer) {
        return repository.save(answer);
    }
    public boolean delete (Long id) {
        repository.deleteById(id);
        return repository.getOne(id) == null ? true : false;
    }
    public AnswerDto convertToDto (Answer entity) {
        return modelMapper.map(entity, AnswerDto.class);
    }
    public Answer convertToEntity (AnswerDto dto) {
        return modelMapper.map(dto, Answer.class);
    }
}
