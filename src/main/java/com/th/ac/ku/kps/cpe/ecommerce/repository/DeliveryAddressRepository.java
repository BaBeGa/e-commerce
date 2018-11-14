package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.DeliveryAddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryAddressRepository extends CrudRepository<DeliveryAddressEntity, Integer> {
    DeliveryAddressEntity findByIdAddress(Integer id_address);
}
