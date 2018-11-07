package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductPicEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductPicRepository extends CrudRepository<ProductPicEntity, Integer> {
    List<ProductPicEntity> findAllByIdProduct(Integer id_product);
}
