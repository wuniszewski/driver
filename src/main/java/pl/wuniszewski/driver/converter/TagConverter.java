package pl.wuniszewski.driver.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wuniszewski.driver.dto.TagDto;
import pl.wuniszewski.driver.entity.Tag;

@Component
public class TagConverter {
    private ModelMapper modelMapper;
    @Autowired
    public TagConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public TagDto convertToDto (Tag entity) {
        return modelMapper.map(entity, TagDto.class);
    }
    public Tag convertToEntity (TagDto dto) {
        return modelMapper.map(dto, Tag.class);
    }
}
