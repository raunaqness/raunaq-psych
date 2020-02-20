package com.psych.game;

import com.psych.game.model.*;
import com.psych.game.repositories.GamesRepository;
import com.psych.game.repositories.PlayerRepository;
import com.psych.game.repositories.QuestionRepository;
import com.psych.game.repositories.RoundsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dev-test")
public class HelloWorldController {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private RoundsRepository roundsRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/populate")
    public String populateDB() {

        Player luffy = new Player.Builder()
                .alias("Monkey D. Luffy")
                .email("luffy@interviewbit.com")
                .saltedHashedPassword("strawhat")
                .build();
        playerRepository.save(luffy);
        Player robin = new Player.Builder()
                .alias("Nico Robin")
                .email("robin@interviewbit.com")
                .saltedHashedPassword("poneglyph")
                .build();
        playerRepository.save(robin);
        Player tom = new Player.Builder()
                .alias("Tom Riddle")
                .email("tom@interviewbit.com")
                .saltedHashedPassword("riddiculus")
                .build();
        playerRepository.save(tom);

        Player scooby = new Player.Builder()
                .alias("Scooby Doo")
                .email("doo@interviewbit.com")
                .saltedHashedPassword("snacks")
                .build();
        playerRepository.save(scooby);

        questionRepository.save(new Question(
                "What is the most important Poneglyph",
                "Rio Poneglyph",
                GameMode.IS_THIS_A_FACT
        ));

        

        return "populated";
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/question/{id}")
    public Question getQuestionById(@PathVariable(name="id") Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/player/{id}")
    public Player getPlayerById(@PathVariable(name="id") Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gamesRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable(name="id") Long id) {
        return gamesRepository.findById(id).orElseThrow();
    }

    @GetMapping("/rounds")
    public List<Round> getAllRounds() {
        return roundsRepository.findAll();
    }

    @GetMapping("/rounds/{id}")
    public Round getRoundById(@PathVariable(name="id") Long id) {
        return roundsRepository.findById(id).orElseThrow();
    }


    // Admins
    // ContentWriters
}

// localhost:8080/dev-test/