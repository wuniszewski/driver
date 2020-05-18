package pl.wuniszewski.driver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter @Setter
public class AdviceDto {
    private Long id;
    private String name;
    private String description;
    private Set<TagDto> tags;
    private Set<ExerciseDto> exercises;
    private Integer likes;
}
