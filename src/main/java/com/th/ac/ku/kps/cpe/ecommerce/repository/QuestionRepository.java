package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.ZQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<ZQuestionEntity, Integer> {
    ZQuestionEntity findByIdQuestion(Integer id);

}
