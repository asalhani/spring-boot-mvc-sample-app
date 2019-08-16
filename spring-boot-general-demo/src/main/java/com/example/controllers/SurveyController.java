package com.example.controllers;

import com.example.model.Question;
import com.example.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {


    @Autowired
    private SurveyService _surveyService;

    // GET - All Questions
    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> GetSurveyQuestions(@PathVariable String surveyId){

        return _surveyService.retrieveQuestions(surveyId);
    }

    // GET - Question
    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question GetQuestion(@PathVariable String surveyId, @PathVariable String questionId){

        return _surveyService.retrieveQuestion(surveyId, questionId);
    }

    // POST -
    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Void> AddQuestion(@PathVariable String surveyId, @RequestBody Question newQuestion){
        Question question =  _surveyService.addQuestion(surveyId, newQuestion);

        if(question == null)
            return ResponseEntity.badRequest().build();

        URI location =
                ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(question.getId())
                .toUri();

        // set response status
       return  ResponseEntity.created(location).build();
    }
}
