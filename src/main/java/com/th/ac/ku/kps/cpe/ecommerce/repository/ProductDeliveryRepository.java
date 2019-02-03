package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.ProductDeliveryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDeliveryRepository extends CrudRepository<ProductDeliveryEntity, Integer> {
    List<ProductDeliveryEntity> findAllByIdProduct(Integer id_product);
    ProductDeliveryEntity findByIdShip(Integer id_ship);
}
