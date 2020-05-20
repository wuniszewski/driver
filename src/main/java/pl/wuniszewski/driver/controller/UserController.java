package pl.wuniszewski.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wuniszewski.driver.converter.UserConverter;
import pl.wuniszewski.driver.dto.UserDto;
import pl.wuniszewski.driver.entity.User;
import pl.wuniszewski.driver.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private UserConverter userConverter;
    private BCryptPasswordEncoder encoder;
    @Autowired
    public UserController(UserService userService, UserConverter userConverter, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.userConverter = userConverter;
        this.encoder = encoder;
    }
    @PostMapping
    public UserDto createNewUser (@RequestBody UserDto userDto) {
        User newUser = userConverter.convertToEntity(userDto);
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return userConverter.convertToDto(userService.create(newUser));
    }
}
