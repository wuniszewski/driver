package pl.wuniszewski.driver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "advices")
@Getter @Setter
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Tag> tags;
    @OneToMany(mappedBy = "advice", fetch = FetchType.EAGER)
    private Set<Exercise> exercises;
    private Integer likes;
}
