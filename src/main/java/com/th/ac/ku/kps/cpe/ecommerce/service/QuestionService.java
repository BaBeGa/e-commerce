package com.th.ac.ku.kps.cpe.ecommerce.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
    ResponseEntity<?> readQuestionAll();
    ResponseEntity<?> ansResponse(Integer id, Integer choice);

}
