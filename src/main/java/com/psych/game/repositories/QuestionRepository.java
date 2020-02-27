package com.psych.game.repositories;

import com.psych.game.model.GameMode;
import com.psych.game.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value="SELECT * FROM questions WHERE gameMode=:gameMode ORDER BY RAND() LIMIT 1", nativeQuery = true) //todo
    Question getRandomQuestion(GameMode gameMode);
}
