package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.RatingProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingProductRepository extends CrudRepository<RatingProductEntity, Integer> {
    List<RatingProductEntity> findAllByIdUser(Integer id_user);
    RatingProductEntity findByIdUserAndIdProduct(Integer id_user, Integer id_product);
}
