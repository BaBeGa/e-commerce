package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.ShipOfShopEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShipOfShopRepository extends CrudRepository<ShipOfShopEntity, Integer> {
    List<ShipOfShopEntity> findByIdShop(Integer integer);
}
