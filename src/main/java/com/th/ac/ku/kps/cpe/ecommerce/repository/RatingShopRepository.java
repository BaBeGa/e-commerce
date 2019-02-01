package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.RatingShopEntity;
import org.springframework.data.repository.CrudRepository;

public interface RatingShopRepository extends CrudRepository<RatingShopEntity, Integer> {
    RatingShopEntity findByIdOrderHistory(Integer id_order_history);
}
