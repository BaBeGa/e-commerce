package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.ProductHasPromoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductHasPromoRepository extends CrudRepository<ProductHasPromoEntity, Integer> {
    List<ProductHasPromoEntity> findAllByIdProductVariation(Integer id_product_variation);
}
