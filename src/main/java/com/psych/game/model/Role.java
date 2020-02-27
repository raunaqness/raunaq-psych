package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="roles")
public class Role extends Auditable {
    @NotBlank
    @Column(unique = true)
    @Getter
    @Setter
    private String name;

    @NotBlank
    @Setter
    @Getter
    private String description;
}
