package pl.wuniszewski.driver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "answers")
@Getter @Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(name = "is_correct")
    private Boolean isCorrect;
}
