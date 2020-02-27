package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee extends User {
    @NotBlank
    @Getter
    @Setter
    private String address;

    @NotBlank
    @Getter
    @Setter
    private String phoneNumber;

    @NotBlank
    @Getter
    @Setter
    private String name;
}
