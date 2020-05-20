package pl.wuniszewski.driver.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wuniszewski.driver.dto.TagDto;
import pl.wuniszewski.driver.dto.UserDto;
import pl.wuniszewski.driver.entity.Tag;
import pl.wuniszewski.driver.entity.User;

@Component
public class UserConverter {
    private ModelMapper modelMapper;
    @Autowired
    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public UserDto convertToDto (User entity) {
        return modelMapper.map(entity, UserDto.class);
    }
    public User convertToEntity (UserDto dto) {
        return modelMapper.map(dto, User.class);
    }
}
