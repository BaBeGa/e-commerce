package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.ShopHasProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopHasProductRepository extends CrudRepository<ShopHasProductEntity,Integer> {
    List<ShopHasProductEntity> findAllByIdShop(Integer id_shop);
    List<ShopHasProductEntity> findAllByIdProduct(Integer id_product);
    void deleteByIdProduct(int id);

    ShopHasProductEntity findByIdProduct(Integer id_product);
}
