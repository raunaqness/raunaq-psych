package com.psych.game;


import com.psych.game.model.Question;
import com.psych.game.repositories.PlayerRepository;
import com.psych.game.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dev-test")
public class HelloWorldController {

    @Autowired // dependency injection
    private PlayerRepository playerRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public HelloWorldController(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public String hello(){

        return "Hello, World!";
    }


    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestionsById(@PathVariable(name="id") Long id){
        return questionRepository.findById(id).orElseThrow();
    }

    //games
    //players
    //admin
    //content writers


}
