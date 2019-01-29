package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.RatingProductEntity;
import org.springframework.data.repository.CrudRepository;


public interface RatingProductRepository extends CrudRepository<RatingProductEntity, Integer> {
    RatingProductEntity findByIdRatingProduct(Integer id_rating_product);
    RatingProductEntity findByIdOrderHistory(Integer id_order_history);
}
