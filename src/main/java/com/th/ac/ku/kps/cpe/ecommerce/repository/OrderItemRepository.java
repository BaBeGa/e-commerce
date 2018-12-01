package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Integer> {
    List<OrderItemEntity> findAllByIdOrder(Integer id_order);
    OrderItemEntity findByIdItem(Integer id_item);

    OrderItemEntity findByIdOrder(Integer id_order);

}
