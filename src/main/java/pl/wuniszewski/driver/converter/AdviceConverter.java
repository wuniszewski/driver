package pl.wuniszewski.driver.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wuniszewski.driver.dto.AdviceDto;
import pl.wuniszewski.driver.entity.Advice;

@Component
public class AdviceConverter {
    private ModelMapper modelMapper;
    @Autowired
    public AdviceConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public AdviceDto convertToDto (Advice entity) {
        return modelMapper.map(entity, AdviceDto.class);
    }
    public Advice convertToEntity (AdviceDto dto) {
        return modelMapper.map(dto, Advice.class);
    }
}
