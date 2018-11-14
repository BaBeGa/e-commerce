package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.OrderPaymentEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderPaymentRepository extends CrudRepository<OrderPaymentEntity, Integer> {
    OrderPaymentEntity findByIdOrder(Integer id_order);
}
