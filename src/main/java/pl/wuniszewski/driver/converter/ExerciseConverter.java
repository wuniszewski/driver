package pl.wuniszewski.driver.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wuniszewski.driver.dto.ExerciseDto;
import pl.wuniszewski.driver.entity.Exercise;

@Component
public class ExerciseConverter {
    private ModelMapper modelMapper;
    @Autowired
    public ExerciseConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ExerciseDto convertToDto (Exercise entity) {
        return modelMapper.map(entity, ExerciseDto.class);
    }
    public Exercise convertToEntity (ExerciseDto dto) {
        return modelMapper.map(dto, Exercise.class);
    }
}
