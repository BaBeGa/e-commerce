package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.OrderHistoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderHistoryRepository extends CrudRepository<OrderHistoryEntity, Integer> {
    OrderHistoryEntity findByIdItem(Integer id_item);
    List<OrderHistoryEntity> findAllByIdBuyer(Integer id_user);
    List<OrderHistoryEntity> findByIdBuyerAndIdOrderHistory(Integer id_user, Integer id_order_history);
    List<OrderHistoryEntity> findAllByIdBuyerAndIdProduct(Integer id_user, Integer id_product);
}
