package com.psych.game.controller;

import com.psych.game.model.*;
import com.psych.game.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dev-test")
public class DevTestController {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoundRepository roundRepository;
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello, World";
    }

    @GetMapping("/populate")
    public String populateDB() {
        for(Player player: playerRepository.findAll()) {
            player.getGames().clear();
            playerRepository.save(player);
        }

        gameRepository.deleteAll();
        playerRepository.deleteAll();
        questionRepository.deleteAll();

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

        Game game = new Game();
        game.setGameMode(GameMode.IS_THIS_A_FACT);
        game.setLeader(luffy);
        game.getPlayers().add(luffy);
        gameRepository.save(game);

        questionRepository.save(new Question(
                "What is the most important Poneglyph",
                "Rio Poneglyph",
                GameMode.IS_THIS_A_FACT
        ));

        questionRepository.save(new Question(
                "How far can Luffy stretch?",
                "56 Gomu Gomus",
                GameMode.IS_THIS_A_FACT
        ));

        return "populated";
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/question/{id}")
    public Question getQuestionById(@PathVariable(name = "id") Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/player/{id}")
    public Player getPlayerById(@PathVariable(name = "id") Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    @GetMapping("/games")
    public List<Game> getAllGames() { return gameRepository.findAll(); }

    @GetMapping("game/{id}")
    public Game getGameById(@PathVariable(name = "id") Long id) {
        return gameRepository.findById(id).orElseThrow();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable(name = "id") Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @GetMapping("/rounds")
    public List<Round> getAllRounds() { return roundRepository.findAll(); }

    @GetMapping("/round/{id}")
    public Round getRoundById(@PathVariable(name = "id") Long id) { return roundRepository.findById(id).orElseThrow(); }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() { return adminRepository.findAll(); }

    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable(name = "id") Long id) { return adminRepository.findById(id).orElseThrow(); }
}
