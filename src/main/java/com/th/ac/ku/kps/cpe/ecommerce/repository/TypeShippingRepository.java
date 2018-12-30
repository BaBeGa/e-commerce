package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.TypeShippingEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypeShippingRepository extends CrudRepository<TypeShippingEntity, Integer> {
    TypeShippingEntity findByIdType(Integer id_type);

    TypeShippingEntity findByNameShip(String name_ship);
}
