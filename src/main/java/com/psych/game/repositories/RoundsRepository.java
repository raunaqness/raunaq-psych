package com.psych.game.repositories;

import com.psych.game.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundsRepository extends JpaRepository<Round, Long> {
}