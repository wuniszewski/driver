package pl.wuniszewski.driver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class ExerciseDto {
    private Long id;
    private String question;
    private AdviceDto advice;
    private Set<AnswerDto> answerss;

}
