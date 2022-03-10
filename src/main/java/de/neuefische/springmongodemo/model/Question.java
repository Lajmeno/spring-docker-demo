package de.neuefische.springmongodemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("questions")
@Data
public class Question {

    @Id
    private String id;

    private String question;

    private int num;

    public Question patch(Question question) {
        if(question.getQuestion() != null){
            setQuestion(question.getQuestion());
        }else if(question.getNum() != 0){
            setNum(question.getNum());
        }
        return this;
    }
}
