package com.psych.game;

import com.psych.game.config.ApplicationContextProvider;
import com.psych.game.config.SpringConfiguration;
import com.psych.game.model.EllenAnswer;
import com.psych.game.model.GameMode;
import com.psych.game.model.Question;
import com.psych.game.repositories.EllenAnswerRepository;
import com.psych.game.repositories.QuestionRepository;

public class Utils {
    private static QuestionRepository questionRepository;
    private static EllenAnswerRepository ellenAnswerRepository;

    static {
        questionRepository = (QuestionRepository) ApplicationContextProvider
                .getApplicationContext()
                .getBean("questionRepository");
        ellenAnswerRepository = (EllenAnswerRepository) ApplicationContextProvider
                .getApplicationContext()
                .getBean("ellenAnswerRepository");
    }

    public static Question getRandomQuestion(GameMode gameMode) {
        return questionRepository.getRandomQuestion(gameMode);
    }

    public static EllenAnswer getRandomEllenAnswer(Question question) {
        return ellenAnswerRepository.getRandomAnswer(question);
    }
}
