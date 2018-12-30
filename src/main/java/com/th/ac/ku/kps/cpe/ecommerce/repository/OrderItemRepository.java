package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Integer> {
    List<OrderItemEntity> findAllByIdOrder(Integer id_order);
    List<OrderItemEntity> findAllByIdOrderAndIdItem(Integer id_order, Integer id_item);
    OrderItemEntity findByIdItem(Integer id_item);

    OrderItemEntity findByIdOrder(Integer id_order);

}
