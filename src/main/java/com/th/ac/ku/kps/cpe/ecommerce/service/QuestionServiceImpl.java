package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.ZQuestionEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.question.AnsResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.question.QuestionBodyReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.question.QuestionReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.QuestionRepository;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public ResponseEntity<?> readQuestionAll() {
        List<ZQuestionEntity> questionEntityList = questionRepository.findAll();
        QuestionReadResponse response = new QuestionReadResponse();
        List<QuestionBodyReadResponse> bodyList = new ArrayList<>();
        for (ZQuestionEntity questionEntity : questionEntityList) {
            QuestionBodyReadResponse body = new QuestionBodyReadResponse();
            body.setId(questionEntity.getIdQuestion());
            body.setQuestion(questionEntity.getQuestion());
            String[] choice = new String[3];
            choice[0] = questionEntity.getChoice1();
            choice[1] = questionEntity.getChoice2();
            choice[2] = questionEntity.getChoice3();
            body.setChoice(choice);
            bodyList.add(body);
        }
        response.setQuestion(bodyList);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> ansResponse(Integer id, Integer choice) {
        ZQuestionEntity questionEntity = questionRepository.findByIdQuestion(id);
        AnsResponse ansResponse = new AnsResponse();
        if(choice == questionEntity.getCorrectChoice()) {
            ansResponse.setResult("correct");
        }
        else {
            ansResponse.setResult("wrong");
            ansResponse.setCorrect_choice(questionEntity.getCorrectChoice());
        }
        return ResponseEntity.ok(ansResponse);
    }
}
