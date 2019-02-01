package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.TypePaymentEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypePaymentRepository extends CrudRepository<TypePaymentEntity, Integer> {
    TypePaymentEntity findByIdTypePayment(Integer id_type_payment);
}
