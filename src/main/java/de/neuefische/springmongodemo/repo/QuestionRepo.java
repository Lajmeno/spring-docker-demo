package de.neuefische.springmongodemo.repo;

import de.neuefische.springmongodemo.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends MongoRepository<Question, String> {

    List<Question> getQuestionByNum(int num);
}
