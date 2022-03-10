package de.neuefische.springmongodemo.service;

import de.neuefische.springmongodemo.model.Question;
import de.neuefische.springmongodemo.repo.QuestionRepo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionsServiceTest {


    @Test
    void shouldChangeNumOfQuestionTo2(){

        QuestionRepo mockRepo = mock(QuestionRepo.class);
        Question questionInDB = new Question();
        questionInDB.setQuestion("Wie Was?");
        questionInDB.setNum(1);
        String testId= "33Q";
        questionInDB.setId(testId);

        when(mockRepo.findById(testId)).thenReturn(Optional.of(questionInDB));
        Question pQuestion = questionInDB;
        pQuestion.setNum(2);

        when(mockRepo.save(pQuestion)).thenReturn(pQuestion);

        QuestionsService service = new QuestionsService(mockRepo);
        Optional<Question> changedQuestion = service.changeQuestionFromDB(pQuestion, testId);

        questionInDB.setNum(2);
        Assertions.assertThat(changedQuestion).isEqualTo(Optional.of(questionInDB));

    }

}