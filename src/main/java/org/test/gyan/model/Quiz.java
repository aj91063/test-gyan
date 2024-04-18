package org.test.gyan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quiz extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;
    private String quizName;
    @Column(name = "description", length = 5000)
    private String description;
    private Boolean publish=false;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "subCategoryId", referencedColumnName = "subCategoryId")
    private SubCategory subCategory;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Question> questions;

}
