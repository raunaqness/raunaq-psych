package com.psych.game.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ellenanswers")
public class EllenAnswer extends Auditable {
    @ManyToOne
    @JsonBackReference
    @NotNull
    @Getter
    @Setter
    private Question question;

    @Getter
    @Setter
    private Long votes = 0L;

    @NotBlank
    @Getter
    @Setter
    private String answer;
}
