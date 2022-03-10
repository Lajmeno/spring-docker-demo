package de.neuefische.springmongodemo;

import de.neuefische.springmongodemo.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringMongoDemoApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldGetAllQuestions(){
		Question question = new Question();
		question.setQuestion("Wofür steht IT?");
		question.setId("23a");
		ResponseEntity<Question> response = restTemplate.postForEntity("/questions", question, Question.class);

		Question[] questionArray = new Question[1];
		questionArray[0] =question;

		Question[] questions = restTemplate.getForObject("/questions", Question[].class);

		Assertions.assertThat(questions).contains(questionArray);
		System.out.println(questions);
	}

	@Test
	void shouldCreateAndReturnQuestion(){

		Question question = new Question();
		question.setQuestion("Wofür steht IT?");
		ResponseEntity<Question> response = restTemplate.postForEntity("/questions", question, Question.class);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody().getQuestion()).isEqualTo("Wofür steht IT?");
	}

	@Test
	void contextLoads() {
	}

}
