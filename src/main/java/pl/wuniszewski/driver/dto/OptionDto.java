package pl.wuniszewski.driver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OptionDto {
    private Long id;
    private String description;
    private Boolean isCorrect;
}
