package de.neuefische.springmongodemo.controller;

import de.neuefische.springmongodemo.model.Question;
import de.neuefische.springmongodemo.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionsController {

    private final QuestionsService questionsService;

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionsService.getAll();
    }

    @PostMapping
    public Question addQuestionToDB(@RequestBody Question question){
        return questionsService.add(question);
    }

    @GetMapping("/num/{num}")
    public List<Question> getQuestionByNum(@PathVariable int num){
        return questionsService.getByNum(num);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable String id){
        return ResponseEntity.of(questionsService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Question> patchQuestionFromDB(@RequestBody Question question, @PathVariable String id) {
        return ResponseEntity.of(questionsService.changeQuestionFromDB(question, id));
    }

}
