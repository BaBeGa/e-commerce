package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.ShopHasProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopHasProductRepository extends CrudRepository<ShopHasProductEntity,Integer> {
    Iterable<ShopHasProductEntity> findAllByIdShop(Iterable<Integer> iterable);
    void deleteByIdProduct(int id);
}
