package pl.wuniszewski.driver.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wuniszewski.driver.dto.AnswerDto;
import pl.wuniszewski.driver.entity.Answer;

@Component
public class AnswerConverter {
    private ModelMapper modelMapper;
    @Autowired
    public AnswerConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public AnswerDto convertToDto (Answer entity) {
        return modelMapper.map(entity, AnswerDto.class);
    }
    public Answer convertToEntity (AnswerDto dto) {
        return modelMapper.map(dto, Answer.class);
    }
}
