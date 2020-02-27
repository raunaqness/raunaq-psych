package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Inherited;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Auditable {
    @Email
    @NotBlank
    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    @NotBlank
    @Getter
    private String saltedHashedPassword;

    public void setSaltedHashedPassword(String value) {
        this.saltedHashedPassword = new BCryptPasswordEncoder(5).encode(value);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Stat stat = new Stat();

    @ManyToMany(mappedBy = "players")
    @Getter
    @Setter
    private Set<Game> games = new HashSet<>();

    public User() { }

    public User(User user) {
        email = user.getEmail();
        saltedHashedPassword = user.getSaltedHashedPassword();
        roles = user.getRoles();
    }
}
