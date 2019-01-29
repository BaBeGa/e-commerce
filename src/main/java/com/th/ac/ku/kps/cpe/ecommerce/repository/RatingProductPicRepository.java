package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.RatingProductPicEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingProductPicRepository extends CrudRepository<RatingProductPicEntity, Integer> {
    List<RatingProductPicEntity> findAllByIdRatingProduct(Integer id_rating_product);
    RatingProductPicEntity findByContentPic(String content_pic);
}
