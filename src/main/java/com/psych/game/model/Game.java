package com.psych.game.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "games")
public class Game extends Auditable {
    @ManyToMany
    @JsonIdentityReference
    @Getter
    @Setter
    private Set<Player> players = new HashSet<>();

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @NotNull
    private GameMode gameMode;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    @JsonIgnore
    @Getter
    @Setter
    private List<Round> rounds = new ArrayList<>();

    @Getter
    @Setter
    private int numRounds = 10;

    @Getter
    @Setter
    private Boolean hasEllen = false;

    @NotNull
    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    private Player leader;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @Getter
    @Setter
    private Map<Player, Stat> playerStats = new HashMap<>();

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private GameStatus gameStatus = GameStatus.PLAYERS_JOINING;

    @ManyToMany
    @JsonIgnore
    @Getter
    @Setter
    private Set<Player> readyPlayers = new HashSet<>();
}
