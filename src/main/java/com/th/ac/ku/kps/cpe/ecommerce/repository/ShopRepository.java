package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Integer> {
    ShopEntity save(ShopEntity shopEntity);

    Iterable<ShopEntity> findAllByIdUser(Iterable<Integer> iterable);

    ShopEntity findByIdShop(Integer id_shop);
    ShopEntity findByIdUser(Integer id_user);
}
