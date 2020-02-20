package com.psych.game.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question extends Auditable {

    @NotNull
    @Getter
    @Setter
    private String question;

    @NotNull
    @Getter
    @Setter
    private String correctAnswer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @Getter
    @Setter
    private Set<EllenAnswer> ellenAnswers = new HashSet<>();

    @NotNull
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private GameMode gameMode;

}
