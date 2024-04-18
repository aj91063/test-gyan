package org.test.gyan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Question extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(name = "title", length = 5000)
    private String title;
    @Column(name = "solution", length = 5000)
    private String solution;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String answer;

    private String image="profile.jpg";

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quizId", referencedColumnName = "quizId")
    private Quiz quiz;


}
