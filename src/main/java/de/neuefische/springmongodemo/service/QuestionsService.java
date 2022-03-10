package de.neuefische.springmongodemo.service;


import de.neuefische.springmongodemo.model.Question;
import de.neuefische.springmongodemo.repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionsService {

    private final QuestionRepo questionRepo;

    public List<Question> getAll(){
        return questionRepo.findAll();
    }

    public Question add(Question question) {
        return questionRepo.save(question);
    }


    public List<Question> getByNum(@PathVariable int num){
        return questionRepo.getQuestionByNum(num);
    }


    public Optional<Question> getById(String id) {
        return questionRepo.findById(id);
    }

    public Optional<Question> changeQuestionFromDB(Question question, String id) {
        question.setId(id);
        return questionRepo.findById(id)
                .map(q ->q.patch(question))
                .map(q -> questionRepo.save(q));
    }
}
