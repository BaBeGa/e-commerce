package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.repository.QuestionRepository;
import com.th.ac.ku.kps.cpe.ecommerce.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/ecom/api/eshop")

public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/question")
    public ResponseEntity<?> questionReq() {
        QuestionServiceImpl questionService = new QuestionServiceImpl(questionRepository);
        return questionService.readQuestionAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/question/{id}/{choice}")
    public ResponseEntity<?> questionAns(@PathVariable Integer id, @PathVariable Integer choice) {
        QuestionServiceImpl questionService = new QuestionServiceImpl(questionRepository);
        return questionService.ansResponse(id, choice);
    }
}
