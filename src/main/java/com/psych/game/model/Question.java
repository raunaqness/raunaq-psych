package com.psych.game.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question extends Auditable {
    @NotBlank
    @Getter
    @Setter
    private String questionText;

    @NotBlank
    @Getter
    @Setter
    private String correctAnswer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonManagedReference
    @Getter
    @Setter
    private Set<EllenAnswer> ellenAnswers = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @NotNull
    @Getter
    @Setter
    private GameMode gameMode;

    public Question() {
    }

    public Question(@NotNull String questionText, @NotNull String correctAnswer, @NotNull GameMode gameMode) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.gameMode = gameMode;
    }
}
