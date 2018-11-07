package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductVariationEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface ProductVariationRepository extends CrudRepository<ProductVariationEntity, Integer> {
    void deleteByIdVariation(Integer integer);
    ProductVariationEntity findByIdVariation(Integer id_product);
    List<ProductVariationEntity> findAllByIdProduct(Integer id_product);
}
